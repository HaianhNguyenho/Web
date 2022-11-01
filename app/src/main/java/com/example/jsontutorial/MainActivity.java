package com.example.jsontutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.StringWriter;

public class MainActivity extends AppCompatActivity {
    private EditText outputText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.outputText = (EditText)this.findViewById(R.id.editText);
        this.button = (Button) this.findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runExample(view);
            }
        });
    }
  /*  public void runExample(View view)  {
        try {

            Company company = ReadJSONExample.readCompanyJSONFile(this);

            outputText.setText(company.toString());
        } catch(Exception e)  {
            outputText.setText(e.getMessage());
            e.printStackTrace();
        }
    }*/
  public void runExample(View view)  {
      try {
          StringWriter output = new StringWriter();

          Company company = JSONWriterExample.createCompany();


          JSONWriterExample.writeJsonStream(output, company);

          String jsonText = output.toString();

          outputText.setText(jsonText);
      } catch(Exception e)  {
          outputText.setText(e.getMessage());
          e.printStackTrace();
      }
  }
}