package com.example.jisuanqi;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bt_0,bt_1,bt_2,bt_3,bt_4,bt_5,bt_6,bt_7,bt_fuhao,
            bt_8,bt_9,bt_delete,bt_div,bt_multiply,bt_minus,bt_add,bt_equal,bt_dot,bt_clear,bt_sqrt;
    private EditText et_export;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewAndListener();
    }
    private void initViewAndListener() {
        bt_0 = (Button)findViewById(R.id.bt_0);
        bt_0.setOnClickListener(this);

        bt_1 = (Button)findViewById(R.id.bt_1);
        bt_1.setOnClickListener(this);


        bt_2 =(Button) findViewById(R.id.bt_2);
        bt_2.setOnClickListener(this);

        bt_3 = (Button)findViewById(R.id.bt_3);
        bt_3.setOnClickListener(this);

        bt_4 = (Button)findViewById(R.id.bt_4);
        bt_4.setOnClickListener(this);

        bt_5 = (Button)findViewById(R.id.bt_5);
        bt_5.setOnClickListener(this);

        bt_6 = (Button)findViewById(R.id.bt_6);
        bt_6.setOnClickListener(this);

        bt_7 = (Button)findViewById(R.id.bt_7);
        bt_7.setOnClickListener(this);

        bt_8 = (Button)findViewById(R.id.bt_8);
        bt_8.setOnClickListener(this);

        bt_9 = (Button)findViewById(R.id.bt_9);
        bt_9.setOnClickListener(this);

        bt_delete = (Button)findViewById(R.id.bt_delete);
        bt_delete.setOnClickListener(this);

        bt_div = (Button)findViewById(R.id.bt_div);
        bt_div.setOnClickListener(this);

        bt_multiply = (Button)findViewById(R.id.bt_multiply);
        bt_multiply.setOnClickListener(this);

        bt_minus = (Button)findViewById(R.id.bt_minus);
        bt_minus.setOnClickListener(this);


        bt_add = (Button)findViewById(R.id.bt_add);
        bt_add.setOnClickListener(this);

        bt_equal = (Button)findViewById(R.id.bt_equal);
        bt_equal.setOnClickListener(this);

        et_export = (EditText)findViewById(R.id.et_export);

        bt_dot = (Button)findViewById(R.id.bt_dot);
        bt_dot.setOnClickListener(this);

        bt_clear = (Button)findViewById(R.id.bt_clear);
        bt_clear.setOnClickListener(this);

        bt_sqrt = (Button)findViewById(R.id.bt_sqrt);
        bt_sqrt.setOnClickListener(this);

        bt_fuhao = (Button)findViewById(R.id.bt_fuhao);
        bt_fuhao.setOnClickListener(this);
    }
    private boolean calculate;  //记录当前是否进行计算操作
    private String calculater = "";  //操作符
    private double onefirst = 0D;  //定义并初始化第一次的取值
    int i=0;

    //onClick()方法，触发OnClickListener接口
    public void onClick(View v) {
        String nowtext = et_export.getText().toString();  //获取当前文本编辑框的内容
        String strnmb = "";  //定义并初始化操作数为””
        if (nowtext.equals("0")) {  //若当前输入数为0则设置文本编辑框为””
            et_export.setText("0");
        }
        strnmb = et_export.getText().toString();  //根据编辑框的内容更改操作数值
        if(!calculater.equals(""))  //判断上一次操作的数是否为空，非空则建立索引，随之修改当前操作数
        {
            int index = strnmb.lastIndexOf(calculater);      //获取之前的最后索引
            strnmb = strnmb.substring(index+1);              //把新的数字加入
        }

        //分别获取按钮的内容至文本编辑框
        switch (v.getId()) {
            case R.id.bt_fuhao:
                et_export.setText(et_export.getText() + "-");
                calculate = false;
                break;
            case R.id.bt_0:
                et_export.setText(et_export.getText() + "0");
                calculate = false;
                break;
            case R.id.bt_1:
                et_export.setText(et_export.getText() + "1");
                calculate = false;
                break;
            case R.id.bt_2:
                et_export.setText(et_export.getText() + "2");
                calculate = false;
                break;
            case R.id.bt_3:
                et_export.setText(et_export.getText() + "3");
                calculate = false;
                break;
            case R.id.bt_4:
                et_export.setText(et_export.getText() + "4");
                calculate = false;
                break;
            case R.id.bt_5:
                et_export.setText(et_export.getText() + "5");
                calculate = false;
                break;
            case R.id.bt_6:
                et_export.setText(et_export.getText() + "6");
                calculate = false;
                break;
            case R.id.bt_7:
                et_export.setText(et_export.getText() + "7");
                calculate = false;
                break;
            case R.id.bt_8:
                et_export.setText(et_export.getText() + "8");
                calculate = false;
                break;
            case R.id.bt_9:
                et_export.setText(et_export.getText() + "9");
                calculate = false;
                break;
            case R.id.bt_dot:
                if(i!=0){
                    return;
                }
                i++;
                et_export.setText(et_export.getText() + ".");
                calculate = false;
                break;
            //清空数据
            case R.id.bt_clear:
                et_export.setText("");
                calculate = false;
                onefirst= 0D;
                calculater="";
                i=0;
                break;
            //退格键
            case R.id.bt_delete:
                if (TextUtils.isEmpty(et_export.getText())) {
                    return;
                }
                if(nowtext.substring(nowtext.length()-1).equals(".")){
                    i=0;
                }
                calculate = false;
                et_export.setText(nowtext.substring(0, nowtext.length() - 1).length() > 0 ? nowtext.substring(0, nowtext.length() - 1) : "0");//截掉最后一个字符，A ？ B ：C (如果A为真执行B否则执行C)
                break;
            case R.id.bt_div:
                if ((TextUtils.isEmpty(et_export.getText())
                        || calculate) && !calculater.equals("=")) {
                    return;
                }
                opratorCalc(strnmb,"÷");
                i=0;
                calculate = true;
                et_export.setText(et_export.getText() + "÷");
                calculater = "÷";
                break;
            case R.id.bt_multiply:
                if ((TextUtils.isEmpty(et_export.getText())
                        || calculate) && !calculater.equals("=")) {
                    return;
                }
                i=0;
                opratorCalc(strnmb,"*");
                calculate = true;
                et_export.setText(et_export.getText() + "*");
                calculater = "*";
                break;
            case R.id.bt_minus:
                if ((TextUtils.isEmpty(et_export.getText())
                        || calculate) && !calculater.equals("=")) {
                    return;
                }
                i=0;
                opratorCalc(strnmb,"—");
                calculate = true;
                et_export.setText(et_export.getText() + "—");
                calculater = "—";
                break;
            case R.id.bt_add:
                if ((TextUtils.isEmpty(et_export.getText())
                        || calculate) && !calculater.equals("=")) {
                    return;
                }
                i=0;
                opratorCalc(strnmb,"+");
                calculate = true;
                et_export.setText(et_export.getText() + "+");
                calculater = "+";
                break;
            case R.id.bt_sqrt:
                if ((TextUtils.isEmpty(et_export.getText())
                        || calculate) && !calculater.equals("=")) {
                    return;
                }
                i=0;
                opratorCalc(strnmb,"^");
                calculate = true;
                et_export.setText(et_export.getText() + "^");
                calculater = "^";
                break;
            case R.id.bt_equal:
                if(TextUtils.isEmpty(calculater))
                {
                    return;
                }
                i=0;
                opratorResult(strnmb);
                calculater ="=";
                calculate = true;
                et_export.setText(et_export.getText() + "\n=" + String.valueOf(onefirst));
                break;
        }
    }

    //运算函数，按具体操作进行+、-、*、/的运算
    private void operate(String operatorNumber)
    {

        if(operatorNumber.isEmpty()&&!calculater.equals("^")){
            return;
        }


        if(calculater.equals("÷"))
        {
            if(operatorNumber.equals("0")){
                et_export.setText(et_export.getText() + "\n0不能做除数");
                return;
            }
            BigDecimal b1 = new BigDecimal(Double.valueOf(onefirst));
            BigDecimal b2 = new BigDecimal(Double.valueOf(Double.parseDouble(operatorNumber)));
            onefirst = b1.divide(b2).doubleValue();
        }
        else if(calculater.equals("*"))
        {
            BigDecimal b1 = new BigDecimal(Double.valueOf(onefirst));
            BigDecimal b2 = new BigDecimal(Double.valueOf(Double.parseDouble(operatorNumber)));
            onefirst = b1.multiply(b2).doubleValue();
        }
        else if(calculater.equals("+"))
        {   BigDecimal b1 = new BigDecimal(Double.valueOf(onefirst));
            BigDecimal b2 = new BigDecimal(Double.valueOf(Double.parseDouble(operatorNumber)));
            onefirst = b1.add(b2).doubleValue();
        }
        else if(calculater.equals("—"))
        {
            BigDecimal b1 = new BigDecimal(Double.valueOf(onefirst));
            BigDecimal b2 = new BigDecimal(Double.valueOf(Double.parseDouble(operatorNumber)));
            onefirst = b1.subtract(b2).doubleValue();
        }
        else if(calculater.equals("^"))
        {
            if(onefirst<0d)
            {
                et_export.setText(et_export.getText() + "\n负数不能做开方");
                return;
            }
            onefirst= Math.sqrt(onefirst);
        }

    }
    //分别返回计算结果
    public void opratorResult(String operatorNumber)
    {
        operate(operatorNumber);

    }
    //按当前计算结果进行下一次的数据输入及计算
    public void opratorCalc(String operatorNumber,String currentOprator)
    {
        if(TextUtils.isEmpty(calculater))
        {
            onefirst = Double.parseDouble(operatorNumber);
            return;
        }

        if(calculater.equals(currentOprator))
        {
            if(calculater.equals("÷"))
            {
                if(operatorNumber.equals("0")){
                    et_export.setText(et_export.getText() + "\n0不能做除数");
                    return;
                }
                BigDecimal b1 = new BigDecimal(Double.valueOf(onefirst));
                BigDecimal b2 = new BigDecimal(Double.valueOf(Double.parseDouble(operatorNumber)));
                onefirst = b1.divide(b2).doubleValue();

            }
            else if(calculater.equals("*"))
            {
                BigDecimal b1 = new BigDecimal(Double.valueOf(onefirst));
                BigDecimal b2 = new BigDecimal(Double.valueOf(Double.parseDouble(operatorNumber)));
                onefirst = b1.multiply(b2).doubleValue();
            }
            else if(calculater.equals("+"))
            {
                BigDecimal b1 = new BigDecimal(Double.valueOf(onefirst));
                BigDecimal b2 = new BigDecimal(Double.valueOf(Double.parseDouble(operatorNumber)));
                onefirst = b1.add(b2).doubleValue();
            }
            else if(calculater.equals("—"))
            {
                BigDecimal b1 = new BigDecimal(Double.valueOf(onefirst));
                BigDecimal b2 = new BigDecimal(Double.valueOf(Double.parseDouble(operatorNumber)));
                onefirst = b1.subtract(b2).doubleValue();
            }
            else if(calculater.equals("^"))
            {
                onefirst= Math.sqrt(onefirst);
            }
            return;
        }
        operate(operatorNumber);

    }

}