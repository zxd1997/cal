package com.example.zxd1997.cal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String tmp="";
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView) findViewById(R.id.tmp);
    }
    public void button1(View view){
        tmp+=1;
        txt.setText(tmp);
    }
    public void button2(View view){
        tmp+=2;
        txt.setText(tmp);
    }
    public void button3(View view){
        tmp+=3;
        txt.setText(tmp);
    }
    public void button4(View view){
        tmp+=4;
        txt.setText(tmp);
    }
    public void button5(View view){
        tmp+=5;
        txt.setText(tmp);
    }
    public void button6(View view){
        tmp+=6;
        txt.setText(tmp);
    }
    public void button7(View view){
        tmp+=7;
        txt.setText(tmp);
    }
    public void button8(View view){
        tmp+=8;
        txt.setText(tmp);
    }
    public void button9(View view){
        tmp+=9;
        txt.setText(tmp);
    }
    public void button0(View view){
        tmp+=0;
        txt.setText(tmp);
    }
    public void buttonplus(View view){
        tmp+="+";
        txt.setText(tmp);
    }
    public void buttonminus(View view){
        tmp+="-";
        txt.setText(tmp);
    }
    public void buttonmul(View view){
        tmp+="*";
        txt.setText(tmp);
    }
    public void buttondiv(View view){
        tmp+="/";
        txt.setText(tmp);
    }
    public void buttondot(View view){
        tmp+=".";
        txt.setText(tmp);
    }
    public void buttonlb(View view){
        tmp+="(";
        txt.setText(tmp);
    }
    public void buttonrb(View view){
        tmp+=")";
        txt.setText(tmp);
    }
    public void buttonclear(View view){
        tmp=new String("");
        txt.setText(tmp);
    }
    public void buttondel(View view){
        try{
            tmp=tmp.substring(0,tmp.length()-1);
            txt.setText(tmp);
        }catch(Exception e){}
    }
    public boolean can(char t,char c){
        if ((t=='+'||t=='-')&&c!='(') return true;
        if ((t=='*'||t=='/')&&(c=='*'||c=='/')) return true;
        return false;
    }
    public void buttonequal(View view){
        TextView txt=(TextView) findViewById(R.id.result);
        try{
            String temp=tmp+"=";
            String t=tmp;
            tmp=new String("");
            char symbol[]=new char[100];
            double number[]=new double[100];
            int i=0,h=1;
            t+=")";symbol[h]='(';
            while(i<t.length()){
                while(t.charAt(i)=='('){
                    symbol[++h]=t.charAt(i);
                    i++;
                }
                String x="";
                while((t.charAt(i)>='0'&&t.charAt(i)<='9')||t.charAt(i)=='.'){
                    x+=t.charAt(i);
                    i++;
                }
                number[h]=Double.parseDouble(x);
                do{
                    if(t.charAt(i)==')'){
                        while(symbol[h]!='('){
                            switch (symbol[h--]){
                                case'+':number[h]+=number[h+1];break;
                                case'-':number[h]-=number[h+1];break;
                                case'*':number[h]*=number[h+1];break;
                                case'/':if(number[h+1]==0){
                                    txt.setText("Error");
                                    Toast.makeText(MainActivity.this,"Can't divide 0!", Toast.LENGTH_LONG).show();
                                    return;
                                }else
                                    number[h]/=number[h+1];break;
                            }
                        }
                        number[--h]=number[h+1];
                    }else{
                        while(can(t.charAt(i),symbol[h])){
                            switch (symbol[h--]){
                                case'+':number[h]+=number[h+1];break;
                                case'-':number[h]-=number[h+1];break;
                                case'*':number[h]*=number[h+1];break;
                                case'/':if(number[h+1]==0){
                                    txt.setText("Error");
                                    Toast.makeText(MainActivity.this,"Can't divide 0!", Toast.LENGTH_LONG).show();
                                    return;
                                }else
                                    number[h]/=number[h+1];break;
                            }
                        }
                        symbol[++h]=t.charAt(i);
                    }
                    i++;
                }while(i<t.length()&&t.charAt(i-1)==')');
            }
            String s=Double.toString(number[0]);
            s=s.replaceAll("0+?$","");
            s=s.replaceAll("[.]$","");
            TextView tt=(TextView) findViewById(R.id.tmp);
            tt.setText(temp);
            txt.setText(s);
        }catch(Exception e){
            txt.setText("Error");
        }
    }
}
