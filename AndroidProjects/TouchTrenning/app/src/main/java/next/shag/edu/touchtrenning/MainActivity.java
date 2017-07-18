package next.shag.edu.touchtrenning;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ImageButton ib;
    private View selectedItem = null;
    private Button btn;
    private int topX, bottomX, leftXX, rightXX;
    boolean touchFlag = false, dropFlag= false;
    private android.view.ViewGroup.LayoutParams imageParams;
    private int ex, ey;
    private int offSetX = 0;
    private int offSetY = 0;
    private int topY, leftX, rightX, bottomY;
    private Fragment fragF, fragS;
    private ListView lv1, lv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }


}

class MyView extends View {
Paint p;
// координаты для рисования квадрата
float x = 100;
float y = 100;
int side = 100;

// переменные для перетаскивания
boolean drag = false;
float dragX = 0;
float dragY = 0;
public MyView(Context context) {
 super(context);
p = new Paint();
p.setColor(Color.GREEN);
}

protected void onDraw(Canvas canvas) {
// рисуем квадрат
canvas.drawRect(x, y, x + side, y + side, p);
 }

@Override
public boolean onTouchEvent(MotionEvent event) {
 // координаты Touch-события
float evX = event.getX();
float evY = event.getY();

switch (event.getAction()) {// касание началось
case MotionEvent.ACTION_DOWN:
// если касание было начато в пределах квадрата
if (evX >= x && evX <= x + side && evY >= y && evY <= y + side) {
// включаем режим перетаскивания
drag = true;
// разница между левым верхним углом квадрата и точкой касания
 dragX = evX - x;
dragY = evY - y;
}
break;
// тащим
case MotionEvent.ACTION_MOVE:
// если режим перетаскивания включен
if (drag) {
 // определеяем новые координаты для рисования
x = evX - dragX;
y = evY - dragY;
// перерисовываем экран
invalidate();
}
break;
// касание завершено
case MotionEvent.ACTION_UP:
// выключаем режим перетаскивания
drag = false;
break;
}
return true;
}
}
