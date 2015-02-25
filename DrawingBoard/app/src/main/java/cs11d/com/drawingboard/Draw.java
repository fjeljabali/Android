/***************************************
 This class is called in the BoardFragment
 which extends view to use paint.
 ***************************************/

package cs11d.com.drawingboard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julez on 2/20/15.
 */
public class Draw extends View
{
    static Paint paint = new Paint();
    static Path path = new Path();
    static Canvas canvas = new Canvas();
    List<PathColor> pathColorList = new ArrayList();

    public Draw(Context context)
    {
        super(context);

        paint.setAntiAlias(true); //antiAlias makes sharp pictures and res
        paint.setStrokeWidth(16f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND); //rounds edges of lines


    }
    @Override
    public void onDraw(Canvas canvas)
    {
        for (PathColor pathColor : pathColorList) {
            canvas.drawPath(pathColor.path, pathColor.paint);
        }
        canvas.drawARGB(100,255,228,225);
    }

    @Override
    public boolean onTouchEvent (MotionEvent me)
    {
        float x = me.getX();
        float y = me.getY();

        switch(me.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                return true; //true if successful and done

            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                break;//break coz we’re not done with path

            case MotionEvent.ACTION_UP:
                Paint copyCurrentPaint = new Paint(paint);
                Path copyCurrentPath = new Path(path);
                PathColor copyPathColor = new PathColor(copyCurrentPaint, copyCurrentPath);
                pathColorList.add(copyPathColor);

                path.reset();
                break;
            default:
                //when not doing a job return false and don’t do.
                return false;
        }
        invalidate(); //repaint
        return true;
    }


    public void colorChanged(int color)
    {
        paint.setColor(color);
        invalidate();
    }
}
