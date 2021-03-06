package bankzworld.com.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

import bankzworld.com.pojo.NewsArticle;
import bankzworld.com.util.NewsQueryUtils;

/**
 * Loads a list of articles by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class NewsArticleLoader extends AsyncTaskLoader<List<NewsArticle>> {

    /** Query URL */
    private String mUrl;
    public static boolean mPrefThumbnail;

    public NewsArticleLoader(Context context, String url, Boolean prefThumbnail) {
        super(context);
        mUrl = url;
        mPrefThumbnail = prefThumbnail;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<NewsArticle> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of newsArticles.
        List<NewsArticle> newsArticles = NewsQueryUtils.fetchArticleData(mUrl);
        return newsArticles;
    }
}