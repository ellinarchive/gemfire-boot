package demo.transformer;

import com.gemstone.gemfire.pdx.JSONFormatter;
import com.gemstone.gemfire.pdx.PdxInstance;
import com.gemstone.org.json.JSONException;
import com.gemstone.org.json.JSONObject;
import org.springframework.integration.transformer.MessageTransformationException;

public class JsonStringToObjectTransformer
{
  public PdxInstance toObject(String json)
  {
    JSONObject jsonObject = null;
    try {
      jsonObject = new JSONObject(json);
    }
    catch (JSONException e) {
      throw new MessageTransformationException(e.getMessage());
    }
    return JSONFormatter.fromJSON(jsonObject.toString());
  }

  public String toString(Object obj) {
    if (obj == null) {
      return null;
    }
    if ((obj instanceof PdxInstance)) {
      String json = JSONFormatter.toJSON((PdxInstance)obj);

      return json.replaceAll("\\r\\n\\s*", "").replaceAll("\\n\\s*", "").replaceAll("\\s*:\\s*", ":").trim();
    }
    return obj.toString();
  }
}