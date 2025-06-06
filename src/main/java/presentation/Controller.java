package presentation;
import businessLogic.ClientBLL;
import businessLogic.OrderBLL;
import businessLogic.ProductBLL;
import exceptions.InvalidInputException;
import model.Client;
import model.Order;
import model.Product;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Aceasta clasa implementeaza ascultatorii pentru toate butoanele din aplicatie
 */
public class Controller {
    private MainView mainView;

    /**
     * In interiorul constructorului sunt implementati ascultatorii pentru butoane prin instantiere claselor si efectuarea operatiilor specifice fiecarui buton in parte
     * @param mainView reprezinta un obiect al clasei MainView care reprezinta meniul principal al aplicatiei si punctul din care pleaca celelalte interfete cu operatiile lor
     * @see MainView
     */
    public Controller(MainView mainView){
        this.mainView = mainView;

        this.mainView.clientBtnAL(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ClientView client = new ClientView();
                mainView.setVisible(false);
                client.setVisible(true);

                client.addClientBtnAL(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String idString = "", name = "", address = "", email = "";
                        idString = client.getClientID();
                        int id = Integer.parseInt(idString);
                        name = client.getClientName();
                        address = client.getClientAddress();
                        email = client.getClientEmail();

                        Client newClient = new Client(id, name, address, email);
                        ClientBLL clientBLL = new ClientBLL();
                        clientBLL.insertClient(newClient);
                    }
                });

                client.deleteClientBtnAL(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String idString = "";
                        idString = client.getClientID();
                        int id = Integer.parseInt(idString);

                        ClientBLL clientBLL = new ClientBLL();
                        clientBLL.deleteClient(id);
                    }
                });

                client.editClientBtn(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String idString = "", email = "";
                        idString = client.getClientID();
                        int id = Integer.parseInt(idString);
                        email = client.getClientEmail();

                        ClientBLL clientBLL = new ClientBLL();
                        clientBLL.editClient(id, email);
                    }
                });

                client.viewClientsBtn(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ClientBLL clientBLL = new ClientBLL();
                        List<Client> clients = clientBLL.viewClients();
                        TableView<Client> table = new TableView<>(clients);
                    }
                });
            }
        });

        this.mainView.productBtnAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductView product = new ProductView();
                mainView.setVisible(false);
                product.setVisible(true);

                product.addProductBtnAL(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String idString = "", name = "", priceString = "", stockString = "";
                        idString = product.getIdProduct();
                        name = product.getNameProduct();
                        priceString = product.getPrice();
                        stockString = product.getStock();

                        int id = Integer.parseInt(idString);
                        int price = Integer.parseInt(priceString);
                        int stock = Integer.parseInt(stockString);

                        Product newProduct = new Product(id, name, price, stock);
                        ProductBLL productBLL = new ProductBLL();
                        productBLL.insertProduct(newProduct);
                    }
                });

                product.deleteProductBtnAL(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String idString = "";
                        idString = product.getIdProduct();

                        int id = Integer.parseInt(idString);

                        ProductBLL productBLL = new ProductBLL();
                        productBLL.deleteProduct(id);
                    }
                });

                product.editProductBtn(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String idString = "", stockString = "";
                        idString = product.getIdProduct();
                        stockString = product.getStock();

                        int id = Integer.parseInt(idString);
                        int stock = Integer.parseInt(stockString);

                        ProductBLL productBLL = new ProductBLL();
                        productBLL.editProduct(id, stock);
                    }
                });

                product.viewProductsBtn(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ProductBLL productBLL = new ProductBLL();
                        List<Product> products = productBLL.viewProducts();
                        TableView<Product> table = new TableView<>(products);
                    }
                });
            }
        });

        this.mainView.orderBtnAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderView order = new OrderView();
                mainView.setVisible(false);
                order.setVisible(true);

                order.createOrderBtnAL(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ProductBLL productBLL = new ProductBLL();
                        OrderBLL orderBLL = new OrderBLL();

                        String idString = order.getIdOrder();
                        String clientName = order.getClientName();
                        String productName = order.getProductName();
                        String quantityString = order.getQuantity();

                        int id = Integer.parseInt(idString);
                        int quantity = Integer.parseInt(quantityString);

                        if(quantity > productBLL.getStock(productName)){
                            try {
                                throw new InvalidInputException("TEMPORARILY OUT OF STOCK!!! Unfortunately, the quantity entered is unavailable for the selected product!");
                            } catch (InvalidInputException ex) {
                                ex.printStackTrace();
                            }
                        }else {
                            int newStock = productBLL.getStock(productName) - quantity;
                            int pricePerProduct = productBLL.getPrice(productName);
                            int finalPrice = pricePerProduct * quantity;
                            productBLL.updateStock(newStock, productName);
                            Order o = new Order(id, clientName, productName, quantity);
                            orderBLL.insert(o);

                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                            LocalDateTime now = LocalDateTime.now();

                            PDDocument document = new PDDocument();
                            PDPage page = new PDPage();
                            document.addPage(page);

                            PDPageContentStream contentStream = null;
                            try {
                                contentStream = new PDPageContentStream(document, page);
                                contentStream.beginText();
                                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                                contentStream.setLeading(50f);
                                contentStream.newLineAtOffset(50, 700);
                                contentStream.showText("Order no: " + idString);
                                contentStream.newLine();
                                contentStream.showText("Client name: " + clientName);
                                contentStream.newLine();
                                contentStream.showText("Product name: " + productName);
                                contentStream.newLine();
                                contentStream.showText("The quantity ordered: " + quantity);
                                contentStream.newLine();
                                contentStream.showText("Price per product: " + pricePerProduct);
                                contentStream.newLine();
                                contentStream.showText("The price for the ordered products: " + finalPrice);
                                contentStream.newLine();
                                contentStream.showText("The order was processed on: " + dtf.format(now));
                                contentStream.endText();
                                contentStream.close();

                                document.save("PDF" + idString + ".pdf");
                                document.close();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }



                        }
                    }
                });
            }
        });

    }
}
