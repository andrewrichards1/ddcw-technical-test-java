package connectors;


import org.json.JSONException;
import org.json.JSONObject;
import play.libs.ws.*;

import javax.inject.Singleton;
import play.Logger;


@Singleton
public class BackendConnector  implements WSBodyReadables, WSBodyWritables{

    private static final String BASE_URL = "http://localhost:1235/backend/print";

    public static void sendMessage(String message)
    {
        try {
            JSONObject obj = new JSONObject();
            obj.put("message", message);
            Logger.debug("created json obj "+ obj.toString());
            RestUtils.makeRequest(BASE_URL, "POST", obj);
        }
        catch (JSONException je)
        {
            je.printStackTrace();
        }
    }

}