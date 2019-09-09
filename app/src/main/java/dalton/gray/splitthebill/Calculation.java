package dalton.gray.splitthebill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class Calculation extends AppCompatActivity {
    final double tipRate = 0.18;

    double totalTIp;
    double totalSplit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        final EditText textBillCost = (EditText) findViewById(R.id.textCost);
        final EditText textGroupSize = (EditText) findViewById(R.id.textGroupSize);
        final Spinner choiceQuality = (Spinner) findViewById(R.id.choiceQuality);

        Button calculate = (Button) findViewById(R.id.buttonCalculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            final TextView tvTip = (TextView) findViewById(R.id.tvTip);
            final TextView tvBillSplit = (TextView) findViewById(R.id.tvBillSplit);

            @Override
            public void onClick(View view) {
                double billCost = Double.parseDouble(textBillCost.getText().toString());
                int groupSize = Integer.parseInt(textGroupSize.getText().toString());
                String quality = choiceQuality.getSelectedItem().toString();
                totalTIp = billCost * tipRate;
                totalSplit = billCost / groupSize;

                DecimalFormat currencyUSD = new DecimalFormat("$###,###.##");

                tvTip.setText("Tip Amount (18%): " + currencyUSD.format(totalTIp));
                tvBillSplit.setText("Individual Bill Split: " + currencyUSD.format(totalSplit));
            }
        });
    }
}
