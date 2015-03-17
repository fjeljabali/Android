/***************************************
 This class allows colors of previously
 drawn objects to stay the same by taking
 in every Path and Paint and saved into
 a List.
 ***************************************/

package cs11d.com.drawingboard;

import android.graphics.Paint;
import android.graphics.Path;

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
