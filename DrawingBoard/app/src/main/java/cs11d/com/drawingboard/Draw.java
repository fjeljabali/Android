package cs11d.com.drawingboard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Julez on 2/20/15.
 */
public class Draw extends View
{
    Paint paint = new Paint();
    Path path = new Path();

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
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent (MotionEvent me)
    {
        float x = me.getX();
        float y = me.getY();

        switch(me.getAction())
        {
            case MotionEvent.ACTION_DOWN: path.moveTo(x,y); return true;//true if successful and done
            case MotionEvent.ACTION_MOVE: path.lineTo(x,y);break;//break coz we’re not done with path
            case MotionEvent.ACTION_UP: break;
            default: return false; //when not doing a job return false and don’t do.
        }
        invalidate(); //repaint
        return true;
    }
}
