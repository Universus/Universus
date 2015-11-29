package app.universus.Helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public class ImagenCircular extends Drawable{
    protected  Bitmap bitmap;
    protected Paint paint;
    protected RectF rectF;
    protected int ancho;
    protected int alto;

    public ImagenCircular(Bitmap bitmap){
        this.bitmap = bitmap;
        rectF = new RectF();
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);

        ancho = bitmap.getWidth()-10;
        alto = bitmap.getHeight()-10;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawOval(rectF, paint);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        rectF.set(bounds);
    }

    @Override
    public void setAlpha(int alpha) {
        if (paint.getAlpha() != alpha) {
            paint.setAlpha(alpha);
            invalidateSelf();
        }
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        paint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public int getIntrinsicWidth() {
        return ancho;
    }

    @Override
    public int getIntrinsicHeight() {
        return alto;
    }

    public void setAntiAlias(boolean aa) {
        paint.setAntiAlias(aa);
        invalidateSelf();
    }

    @Override
    public void setFilterBitmap(boolean filter) {
        paint.setFilterBitmap(filter);
        invalidateSelf();
    }

    @Override
    public void setDither(boolean dither) {
        paint.setDither(dither);
        invalidateSelf();
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
