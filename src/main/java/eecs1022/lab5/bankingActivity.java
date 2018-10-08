package eecs1022.lab5;

import android.icu.text.DecimalFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.*;
import java.lang.String;

public class bankingActivity extends AppCompatActivity
{
    Bank bank;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking);
        setTitle("EECS1022 W18 Lab 5: Extended Bank Application");
        bank = new Bank();

    }

    private void setContentsOfTextView(int id, String newContents)
    {
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);

    }

    private String getInputOfTextField(int id)
    {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;

    }

    private String getItemSelected(int id)
    {
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        return spinner.getSelectedItem().toString();
    }
    public void newClient(View view){
        bank.addClient(getInputOfTextField(R.id.newClientName), getInputOfTextField(R.id.newClientBalance));
        setContentsOfTextView(R.id.output, bank.toString(getInputOfTextField(R.id.outputName)));
    }
    public void outputStatement(View view){
        bank.outputStatement(getInputOfTextField(R.id.outputName));
        setContentsOfTextView(R.id.output, bank.toString(getInputOfTextField(R.id.outputName)));
    }
    public void completeTransaction(View view){
        bank.completeTransaction(getItemSelected(R.id.spinner), getInputOfTextField(R.id.toClient), getInputOfTextField(R.id.fromClient), getInputOfTextField(R.id.amount));
        setContentsOfTextView(R.id.output,bank.toString(getInputOfTextField(R.id.outputName)));
    }

}
