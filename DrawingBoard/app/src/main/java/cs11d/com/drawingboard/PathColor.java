package cs11d.com.drawingboard;

import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by Julez on 2/24/15.
 */
public class PathColor
{
    public final Paint paint;
    public final Path path;

    public PathColor(Paint paint, Path path)
    {
        this.paint = paint;
        this.path = path;
    }

}
