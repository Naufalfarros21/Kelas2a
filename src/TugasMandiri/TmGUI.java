package TugasMandiri;

import Model.ResponseModel;
import Network.ConnectURI;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class TmGUI extends JFrame {
    private JButton btnSubmit;
    private JTextField tfmsg;
    private JTextField tfstts;
    private JTextField tfcmnt;
    private JTextField tfjumkat;
    private JButton btnClose;
    private JPanel mainPanel;

    public TmGUI() throws IOException {
        setContentPane(mainPanel);
        setTitle("TM01_22090051_NAUFALFARROSSDHAROJAT");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);

        ConnectURI koneksiku = new ConnectURI();
        URL myAddres = koneksiku.buildURL
                ("https://harber.mimoapps.xyz/api/getaccess.php");
        String response = koneksiku.getResponseFromHttpUrl(myAddres);
        System.out.println(response);

        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<ResponseModel> responseModel = new ArrayList<>();
        for (int i=0; i< responseJSON.length(); i++) {
            ResponseModel resModel = new ResponseModel();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);
            resModel.setMessage(myJSONObject.getString("message"));
            resModel.setStatus(myJSONObject.getString("status"));
            resModel.setComments(myJSONObject.getString("comment"));
            responseModel.add(resModel);

            BufferedReader jumKat = new BufferedReader(new InputStreamReader(myAddres.openConnection().getInputStream()));
            String line = jumKat.readLine();
            String[] words = line.split("\\s+");
            int count = words.length;
        }




        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ResponseModel model : responseModel) {
                    tfmsg.setText("" + model.getMessage());
                    tfstts.setText("" + model.getStatus());
                    tfcmnt.setText("" + model.getComments());
                    tfjumkat.setText("" + model.getMessage().length());
                }

            }

        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) throws IOException {
         new TmGUI();
    }



}
