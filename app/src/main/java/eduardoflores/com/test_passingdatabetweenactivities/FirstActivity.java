package eduardoflores.com.test_passingdatabetweenactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity
{
    private TextView tvName;
    private TextView tvNumber;
    private EditText etName;
    private Button button;

    public static final String KEY_SENDING_DATA = "sending_data";
    private int REQUEST_CODE = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        tvName = (TextView)findViewById(R.id.tv_name);
        tvNumber = (TextView)findViewById(R.id.tv_number);
        etName = (EditText)findViewById(R.id.et_name);
        button = (Button)findViewById(R.id.button_first_activity);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra(KEY_SENDING_DATA, etName.getText().toString());
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            // get data from second activity
            String numberReceived = data.getStringExtra(SecondActivity.BUNDLE_NUMBER);

            tvNumber.setText("The number from second activity is: " + numberReceived);
            tvNumber.setVisibility(View.VISIBLE);
        }
    }
}
