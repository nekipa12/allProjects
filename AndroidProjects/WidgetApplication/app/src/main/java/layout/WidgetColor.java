package layout;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.widget.RemoteViews;

import widget.shag.edu.widgetapplication.ChooseColorActivity;
import widget.shag.edu.widgetapplication.R;


public class WidgetColor extends AppWidgetProvider {

    public static String result;

    public static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        SharedPreferences sp = context.getSharedPreferences(ChooseColorActivity.WIDGET_PREF, ChooseColorActivity.MODE_PRIVATE);
        result = sp.getString(ChooseColorActivity.WIDGET_TEXT + appWidgetId, null);
        if (result == null) return;
        String [] res = result.split(" ");
        CharSequence widgetText = context.getString(R.string.appwidget_text);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_color);
        views.setTextViewText(R.id.appwidget_text, widgetText);
        views.setInt(R.id.rl, "setBackgroundColor", Color.rgb(Integer.parseInt(res[0]), Integer.parseInt(res[1]), Integer.parseInt(res[2])));
        views.setInt(R.id.appwidget_text, "setBackgroundColor", Color.rgb(Integer.parseInt(res[0]), Integer.parseInt(res[1]), Integer.parseInt(res[2])));
        Intent intent = new Intent(context, ChooseColorActivity.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_CONFIGURE);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        PendingIntent pi = PendingIntent.getActivity(context, appWidgetId, intent, 0);
        views.setOnClickPendingIntent(R.id.rl, pi);
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        SharedPreferences sp = context.getSharedPreferences(ChooseColorActivity.WIDGET_PREF, Context.MODE_PRIVATE);
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }

    }

    @Override
    public void onEnabled(Context context) {
    }

    @Override
    public void onDisabled(Context context) {
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        SharedPreferences.Editor editor = context.getSharedPreferences(ChooseColorActivity.WIDGET_PREF, Context.MODE_PRIVATE).edit();
        for (int widgetID : appWidgetIds) {
            editor.remove(ChooseColorActivity.WIDGET_TEXT + widgetID);
        }
        editor.commit();
    }


}

