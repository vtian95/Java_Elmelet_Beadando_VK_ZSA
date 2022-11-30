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

  



}
