package grafikus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

public class GrafikusController {
    @FXML
    public int n=0;
    public TableView parh1;
    public TableView parh2;
    @FXML
    private Label lbdel;
    @FXML
    public ComboBox cb1;
    @FXML
    private ComboBox cb2;
    @FXML
    private TableView tv2;
    @FXML
    private Label lb2;
    @FXML
    private Label lb1;
    @FXML
    private GridPane gp1;
    @FXML
    private GridPane gp2;
    @FXML
    private GridPane gp6;
    @FXML GridPane gp7;
    @FXML
    private TextField uNév, uTipus, uDijazott;
    @FXML
    private TextField tfNév, tfTipus, tfDijazott;



    @FXML
    private TableView tv1;
    @FXML
    private TableColumn<suti, String> IDCol;
    @FXML
    private TableColumn<suti, String> névCol;
    @FXML
    private TableColumn<suti, String> tipusCol;
    @FXML
    private TableColumn<suti, String> dijazottCol;
    SessionFactory factory;

    @FXML
    void initialize() {
        this.ElemekTörlése();
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        factory = cfg.buildSessionFactory();
    }

    void ElemekTörlése() {
        this.parh1.setVisible(false);
        this.parh1.setManaged(false);
        this.parh2.setVisible(false);
        this.parh2.setManaged(false);

        this.cb1.setVisible(false);
        this.cb2.setManaged(false);
        this.cb1.setVisible(false);
        this.cb2.setManaged(false);
        this.lb1.setVisible(false);
        this.lb1.setManaged(false);
        this.gp1.setVisible(false);
        this.gp1.setManaged(false);
        this.tv1.setVisible(false);
        this.tv1.setManaged(false);
        this.tv2.setVisible(false);
        this.tv2.setManaged(false);
        this.lb2.setVisible(false);
        this.lb2.setManaged(false);
        this.gp2.setVisible(false);
        this.gp2.setManaged(false);
        this.lbdel.setManaged(false);
        this.lbdel.setVisible(false);

    }

    @FXML
    protected void menuCreateClick() {
        this.ElemekTörlése();
        gp1.setVisible(true);
        gp1.setManaged(true);
    }

    @FXML
    protected void menuUpdateClick() {
        this.ElemekTörlése();
        gp2.setVisible(true);
        gp2.setManaged(true);
        cb1.setVisible(true);
        cb1.setManaged(true);
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        List<suti> lista = session.createQuery("FROM suti").list();
        cb1.setPromptText("Válassz egy id-t!");
        for (suti suti : lista){
            cb1.getItems().add(suti.Id);}


    }


    void Create() {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        suti termek = new suti(tfNév.getText(), tfTipus.getText(), Boolean.parseBoolean(tfDijazott.getText()));
        session.save(termek);
        t.commit();
    }

    @FXML
    void bt1Click() {
        Create();
        this.ElemekTörlése();
        lb1.setVisible(true);
        lb1.setManaged(true);
        lb1.setText("Adatok beírva az adatbázisba");
    }

    @FXML
    protected void menuReadClick() {
        this.ElemekTörlése();
        tv1.setVisible(true);
        tv1.setManaged(true);
        tv1.getColumns().removeAll(tv1.getColumns());
        IDCol = new TableColumn("Id");
        névCol = new TableColumn("Név");
        tipusCol = new TableColumn("Típus");
        dijazottCol = new TableColumn("Díjazott");
        tv1.getColumns().addAll(IDCol, névCol, tipusCol, dijazottCol);
        IDCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        névCol.setCellValueFactory(new PropertyValueFactory<>("Név"));
        tipusCol.setCellValueFactory(new PropertyValueFactory<>("Típus"));
        dijazottCol.setCellValueFactory(new PropertyValueFactory<>("Díjazott"));
        tv1.getItems().clear();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        List<suti> lista = session.createQuery("FROM suti").list();
        for (suti suti : lista)
            tv1.getItems().add(suti);
        System.out.println();
        t.commit();
    }


    @FXML
    void Update() {

        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        System.out.println("Update..");
         int n = cb1.getVisibleRowCount();
        suti suti = session.load(grafikus.suti.class, n);

        suti.setNév(uNév.getText());
        suti.setTípus(uTipus.getText());
        suti.setDíjazott(Boolean.parseBoolean((uDijazott.getText())));

        session.update(suti);
        t.commit();

    }

    public void bt2Click(ActionEvent actionEvent) {
        this.ElemekTörlése();
        Update();

        lb2.setVisible(true);
        lb2.setManaged(true);
        lb2.setText("Update lefutott!");
    }

    @FXML
    protected void menuDeleteClick() {
        ElemekTörlése();
        lbdel.setVisible(true);
        lbdel.setManaged(true);
        tv1.getColumns().removeAll(tv1.getColumns());
        Session session = factory.openSession();

        System.out.println("Delete..");
        Transaction t = session.beginTransaction();
        suti suti = session.load(suti.class, 1);
        session.delete(suti);
        t.commit();
        lbdel.setText("Az 1.-es id-val rendelkező sor törlésre került!");
    }


    @FXML
    protected void menuReadClick_2() {
        this.ElemekTörlése();
        tv1.setVisible(true);
        tv1.setManaged(true);
        tv1.getColumns().removeAll(tv1.getColumns());
        IDCol = new TableColumn("Id");
        névCol = new TableColumn("Név");
        tipusCol = new TableColumn("Típus");
        dijazottCol = new TableColumn("Díjazott");
        tv1.getColumns().addAll(IDCol, névCol, tipusCol, dijazottCol);
        IDCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        névCol.setCellValueFactory(new PropertyValueFactory<>("Név"));
        tipusCol.setCellValueFactory(new PropertyValueFactory<>("Típus"));
        dijazottCol.setCellValueFactory(new PropertyValueFactory<>("Díjazott"));
        tv1.getItems().clear();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        List<suti> lista = session.createQuery("FROM suti").list();
        for (suti suti : lista)
            tv1.getItems().add(suti);
        System.out.println();
        t.commit();

    }

    @FXML
    protected void Rest1Create1() {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        suti termek = new suti(tfNév.getText(), tfTipus.getText(), Boolean.parseBoolean(tfDijazott.getText()));
        session.save(termek);
        t.commit();

    }

    @FXML
    protected void Rest1Read1() {

        this.ElemekTörlése();
        tv1.setVisible(true);
        tv1.setManaged(true);
        tv1.getColumns().removeAll(tv1.getColumns());
        IDCol = new TableColumn("Id");
        névCol = new TableColumn("Név");
        tipusCol = new TableColumn("Típus");
        dijazottCol = new TableColumn("Díjazott");
        tv1.getColumns().addAll(IDCol, névCol, tipusCol, dijazottCol);
        IDCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        névCol.setCellValueFactory(new PropertyValueFactory<>("Név"));
        tipusCol.setCellValueFactory(new PropertyValueFactory<>("Típus"));
        dijazottCol.setCellValueFactory(new PropertyValueFactory<>("Díjazott"));
        tv1.getItems().clear();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        List<suti> lista = session.createQuery("FROM suti").list();
        for (suti suti : lista)
            tv1.getItems().add(suti);
        System.out.println();
        t.commit();
        lb2.setText("Rest, Read lefutott!!");
    }

    @FXML
    protected void Rest1Update1() {

        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        System.out.println("Update..");
        int n = cb1.getVisibleRowCount();
        suti suti = session.load(grafikus.suti.class, n);

        suti.setNév(uNév.getText());
        suti.setTípus(uTipus.getText());
        suti.setDíjazott(Boolean.parseBoolean((uDijazott.getText())));

        session.update(suti);
        t.commit();
    }

    @FXML
    protected void Rest1Delete1() {
        ElemekTörlése();
        lbdel.setVisible(true);
        lbdel.setManaged(true);
        tv1.getColumns().removeAll(tv1.getColumns());
        Session session = factory.openSession();

        System.out.println("Delete..");
        Transaction t = session.beginTransaction();
        suti suti = session.load(suti.class, 2);
        session.delete(suti);
        t.commit();
        lbdel.setText("Rest_Delete, 2-es id törlése került!");
    }

    @FXML
    protected void Rest2Create() {
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        suti termek = new suti(tfNév.getText(), tfTipus.getText(), Boolean.parseBoolean(tfDijazott.getText()));
        session.save(termek);
        t.commit();
    }

    @FXML
    protected void Rest2Read1() {
        this.ElemekTörlése();
        tv1.setVisible(true);
        tv1.setManaged(true);
        tv1.getColumns().removeAll(tv1.getColumns());
        IDCol = new TableColumn("Id");
        névCol = new TableColumn("Név");
        tipusCol = new TableColumn("Típus");
        dijazottCol = new TableColumn("Díjazott");
        tv1.getColumns().addAll(IDCol, névCol, tipusCol, dijazottCol);
        IDCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        névCol.setCellValueFactory(new PropertyValueFactory<>("Név"));
        tipusCol.setCellValueFactory(new PropertyValueFactory<>("Típus"));
        dijazottCol.setCellValueFactory(new PropertyValueFactory<>("Díjazott"));
        tv1.getItems().clear();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        List<suti> lista = session.createQuery("FROM suti").list();
        for (suti suti : lista)
            tv1.getItems().add(suti);
        System.out.println();
        t.commit();
    }

    @FXML
    protected void Rest2Update1() {

        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        System.out.println("Update..");
        int n = cb1.getVisibleRowCount();
        suti suti = session.load(grafikus.suti.class, n);

        suti.setNév(uNév.getText());
        suti.setTípus(uTipus.getText());
        suti.setDíjazott(Boolean.parseBoolean((uDijazott.getText())));

        session.update(suti);
        t.commit();
    }

    @FXML
    protected void Rest2Delete1() {
        ElemekTörlése();
        lbdel.setVisible(true);
        lbdel.setManaged(true);
        tv1.getColumns().removeAll(tv1.getColumns());
        Session session = factory.openSession();

        System.out.println("Delete..");
        Transaction t = session.beginTransaction();
        suti suti = session.load(suti.class, 3);
        session.delete(suti);
        t.commit();
        lbdel.setText("Rest2_Delete! 3-as id törlésre került!!");
    }

    @FXML
    protected void Soapletoltes() {
    }

    @FXML
    protected void Soapletoltes2() {
    }

    @FXML
    protected void Soapgrafikon() {
    }

    @FXML
    protected void Adatb_Dontesi_Fa() {
    }

    @FXML
    protected void Adatb_tobbalgo() {
    }

    @FXML
    protected void Adatb_tobbalgo2() {
    }

    @FXML
    protected void Parhuzamos() throws InterruptedException {
        this.ElemekTörlése();
        parh1.setVisible(true);
        parh1.setManaged(true);
        parh1.getColumns().removeAll(parh1.getColumns());

        névCol = new TableColumn("Név");
        tipusCol = new TableColumn("Típus");

        parh1.getColumns().addAll( névCol, tipusCol);

        névCol.setCellValueFactory(new PropertyValueFactory<>("Név"));
        tipusCol.setCellValueFactory(new PropertyValueFactory<>("Típus"));

        parh1.getItems().clear();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();



        new Thread(){		// itt van a tömörítés
            public void run()
            {
                while(true){

                    try{
                        System.out.println("Egyik szál");
                        List<suti> lista = session.createQuery("FROM suti").list();
                        lista.stream().forEach
                                (a -> System.out.println(a.getNév()+": "+a.getTípus()))
                        ;
                        for (suti ujsuti : lista)
                            parh1.getItems().add(ujsuti);
                        Thread.sleep(1000);
                        t.commit();
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        while(true){
            System.out.println("Másik szál");

            List<suti> lista = session.createQuery("FROM suti").list();
            lista.stream().forEach
                    (a -> System.out.println(a.getNév()+": "+a.getTípus()))
            ;
            for (suti ujsuti : lista)
                parh1.getItems().add(ujsuti.Név);
            Thread.sleep(2000);

            t.commit();
        }






















    }

    @FXML
    protected void Stream() {
    }



}
