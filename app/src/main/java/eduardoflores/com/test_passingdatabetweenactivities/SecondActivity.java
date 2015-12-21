package eduardoflores.com.test_passingdatabetweenactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Eduardo Flores
 */
public class SecondActivity extends AppCompatActivity
{
    private TextView tvName;
    private TextView tvNumber;
    private EditText etNumber;
    private Button button;

    public static final String BUNDLE_NUMBER = "number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvName = (TextView)findViewById(R.id.tv_name_second);
        tvNumber = (TextView)findViewById(R.id.tv_number_second);
        etNumber = (EditText)findViewById(R.id.et_number_second);
        button = (Button)findViewById(R.id.button_second_activity);

        // get data from first activity
        Intent intent = getIntent();
        String nameReceived = intent.getStringExtra(FirstActivity.KEY_SENDING_DATA);

        // display the name received
        tvName.setText("Your name is: " + nameReceived);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra(BUNDLE_NUMBER, etNumber.getText().toString());
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}
