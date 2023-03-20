import Model.ResponseModel;
import Network.ConnectURI;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FirstConnect {
    public static void main(String[] args) throws IOException {
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
        }

        System.out.println("Response are : ");
        for (int index=0; index<responseModel.size(); index++){
            System.out.println("MASSAGE : " + responseModel.get(index).getMessage());
            System.out.println("STATUS : " + responseModel.get(index).getStatus());
            System.out.println("COMMENTS : " + responseModel.get(index).getComments());
        }
    }
}
