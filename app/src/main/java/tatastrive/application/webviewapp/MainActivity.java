package tatastrive.application.webviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button loadWebPage,loadFromStaticHtml;
    WebView simpleWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        loadWebPage=findViewById( R.id.loadWebPage );
        loadFromStaticHtml=findViewById( R.id.loadFromStaticHtml );
        simpleWebView=findViewById( R.id.simpleWebView );
        loadFromStaticHtml.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        String customHtml = "<html><body><h1>Hello, Android App Developer</h1>" +
                                "<h1>Heading 1</h1><h2>Heading 2</h2><h3>Heading 3</h3>" +
                                "<p>This is a sample paragraph of static HTML In Web view</p>" +
                                "</body></html>";
                        simpleWebView.loadData( customHtml, "text/html", "UTF-8" ); // load html string data in a web view



                }
        } );
        loadWebPage.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleWebView.setWebViewClient(new MyWebViewClient());
                String url = "https://chandansatyendraprasad.wordpress.com/";
                simpleWebView.getSettings().setJavaScriptEnabled(true);
                simpleWebView.loadUrl(url); // load a web page in a web view

            }


        } );

    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl( url);
            return true;
        }
    }
}

