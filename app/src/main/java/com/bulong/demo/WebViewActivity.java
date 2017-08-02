package com.bulong.demo;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {
    private String str = "    <string name=\"contract_\"> <p> 二、质量及验收标准：质量按 国家 标准执行，验收按 国家 标准验收。<br></p><p>三、货物交付：提货地为： 安阳。交货方式为：自提，含含；<br>四、付款方式、期限：乙方合同签订当日支付<span style=\\\"padding:0px 10px; font-size: 18px; text-align: center; border-bottom: 1px solid #000; \\\">￥14000.00(大写：壹万肆仟圆整人民币)。</span> <br />五、货物异议：货物数量和外观异议，乙方应于收到货物后2日内向甲方提出，实际收货重量与发货重量误差在3‰以内的，以甲方出库单为准；超过3‰的，甲乙双方协商解决；乙方使用货物前应当对质量进行检验，检验合格后方可使用，如有货物质量异议，乙方应于收到货物后7日内提出，完好保留实物和厂标，由厂家验证确认存在质量问题后等待协商解决，解决办法以厂家处理意见为准。如果乙方未按约定期限提出书面异议或已经使用，视为甲方所交货物数量、规格、质量完全符合合同约定。<br />六、货物异议：货物数量和外观异议，乙方应于收到货物后2日内向甲方提出，实际收货重量与发货重量误差在3‰以内的，以甲方出库单为准；超过3‰的，甲乙双方协商解决；货物质量异议，乙方于收到货物后7日内提出，完好保留实物和厂标，由厂家验证确认存在质量问题后等待协商解决，解决办法以厂家处理意见为准。如果乙方未按约定期限提出书面异议或已经使用，视为甲方所交货物数量、规格、质量完全符合合同约定。<br />七、结算及开票：本合同金额为含税价，以实际供货量为准，多退少补；货款两清后，由甲方向乙方开具17%的增值税专用发票。<br />八、违约责任：按照《合同法》执行。乙方在平台下单后不得随意解除本合同，否则乙方应向甲方支付合同总额30%的违约金。乙方逾期支付货款的，除仍需支付全部货款外，乙方须向甲方承担本合同货款总额 30% 的违约金。<br /> 九、争议解决方式：因本合同引起的或与本合同有关的任何争议，应由双方当事人先行协商；协商不成的，双方同意将争议交由甲方住所地人民法院解决。<br />十、保密约定：本合同价格、数量、技术等属商业机密，未经许可，双方均不得以任何方式向第三方泄露。<br />十一、本合同在双方盖章后生效，双方已明确理解了合同所有条款的意思表达，不得随意解除或修改。传真件、扫描件、网络确认件具有同等法律效力。<br /></string>\n";
    private WebView web_contract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("before_setContent","xdpi:"+getResources().getDisplayMetrics().xdpi+"getxdpi/"+getxdpi(this));
        setContentView(R.layout.activity_web_view);
        Log.e("after_setContent","xdpi:"+getResources().getDisplayMetrics().xdpi+"getxdpi/"+getxdpi(this));
        web_contract =  (WebView)findViewById(R.id.web_contract);
        setContractHtml();
       // Log.e("SK_webview_getScreen","xdpi:"+getResources().getDisplayMetrics().xdpi+"getxdpi/"+getxdpi(this));
    }

    public static int getScreenWidthPix(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    public static float getxdpi(Context context) {
        DisplayMetrics dm = new DisplayMetrics();

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.xdpi;
    }

    public static float getDensity(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getResources().getDisplayMetrics();
        return dm.density;
    }
    private void setContractHtml() {
        WebSettings webSetting = web_contract.getSettings();
        webSetting.setBuiltInZoomControls(true);
        webSetting.setDisplayZoomControls(false);
       /* int zoom = (int)(getDensity(this)*100*0.9);
        webSetting.setTextZoom(zoom);*///文字缩放比例 *0.9
        webSetting.setTextZoom((int)(webSetting.getTextZoom()*0.9));
        web_contract.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); //取消滚动条白边效果
        webSetting.setDefaultTextEncodingName("UTF-8");
        web_contract.loadDataWithBaseURL(null,str, "text/html", "UTF-8", null);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        resetDensity();
    }

    public final static float DESIGN_WIDTH = 750;
    public void resetDensity(){
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        getResources().getDisplayMetrics().xdpi = dm.widthPixels/DESIGN_WIDTH*72f;
        Log.e("SK_webview_reset","xdpi:"+getResources().getDisplayMetrics().xdpi);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // resetDensity();
    }
}
