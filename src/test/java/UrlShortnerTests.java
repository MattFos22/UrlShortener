import com.rosaloves.bitlyj.Url;
import net.swisstech.bitly.BitlyClient;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.ShortenResponse;
import org.junit.Test;

import static com.rosaloves.bitlyj.Bitly.as;
import static com.rosaloves.bitlyj.Bitly.shorten;

public class UrlShortnerTests {

    static final String API_KEY = "R_ac5b7228a73a4ae48be6d2c11caf7fd2";
    static final String GENERIC_OAUTH_TOKEN = "7cb36db360b5b2cb6bb43f07658ede36aae78d51";
    private final String longUrl = "http://salimsbelims.com/mango?id=123";

    @Test
    public void shouldReturnShortenedUrlFromBiglyUrl(){
        Url url = as("mattfoster22", API_KEY)
                .call(shorten(longUrl));
        System.out.println("Shortened:"+ url);
    }

    @Test
    public void shouldReturnShortenedUrlFromBiglyUrlUsingOAuth(){
        BitlyClient client = new BitlyClient(GENERIC_OAUTH_TOKEN);
        Response<ShortenResponse> response = client.shorten().setLongUrl(longUrl).call();
        System.out.println(response.data.url);
    }
}
