package diagram.blur.gaussian.gaussianblurdiagram;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import diagram.blur.gaussian.gaussianblurdiagram.uits.BlurBitmapUtil;

/**
 * 2017-10-12  Mr.Li   Android 高斯模糊图
 */
public class MainActivity extends AppCompatActivity {
    //原图img1，模糊img2,控件
    private ImageView img1,img2;
    //进度条
    private SeekBar sb;
    //显示进度文字控件
    private TextView text;
    //透明度
    private int mAlpha;
    //原始图片 oldbitmap;模糊后的图片 newbitmap
    private Bitmap oldbitmap,newbitmap;

    private MainActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context  = this;
        //绑定组件，初始化视图
        initView();
        //获取图片
        oldbitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.pzy);
        newbitmap = BlurBitmapUtil.blur(this,oldbitmap);
        // 填充模糊后的图像和原图
        img2.setImageBitmap(newbitmap);
        img1.setImageBitmap(oldbitmap);
        // 处理seekbar滑动事件
        setSeekBar();
    }

    private void setSeekBar() {
        sb.setMax(100);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mAlpha = i;
                img1.setAlpha((int) (255 - mAlpha * 2.55));
                text.setText(String.valueOf(mAlpha));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initView() {
        img1 = (ImageView)findViewById(R.id.img1);
        img2 = (ImageView)findViewById(R.id.img2);
        sb = (SeekBar)findViewById(R.id.sb);
        text = (TextView)findViewById(R.id.text);
    }
}
