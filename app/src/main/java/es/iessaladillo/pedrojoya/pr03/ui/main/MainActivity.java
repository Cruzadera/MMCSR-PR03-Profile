package es.iessaladillo.pedrojoya.pr03.ui.main;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import es.iessaladillo.pedrojoya.pr03.R;
import es.iessaladillo.pedrojoya.pr03.data.local.Database;
import es.iessaladillo.pedrojoya.pr03.data.local.model.Avatar;
import es.iessaladillo.pedrojoya.pr03.utils.Field;
import es.iessaladillo.pedrojoya.pr03.utils.KeyboardUtils;
import es.iessaladillo.pedrojoya.pr03.utils.SnackbarUtils;
import es.iessaladillo.pedrojoya.pr03.utils.ValidationUtils;

public class MainActivity extends AppCompatActivity {

    private ImageView imgAvatar;
    private TextView lblAvatar;
    private EditText txtName;
    private EditText txtEmail;
    private EditText txtAddress;
    private EditText txtPhonenumber;
    private EditText txtWeb;
    private ImageView imgEmail;
    private ImageView imgWeb;
    private ImageView imgAddress;
    private ImageView imgPhonenumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        // TODO
    }

    // DO NOT TOUCH
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // DO NOT TOUCH
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnuSave) {
            save();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initViews() {
        lblAvatar = ActivityCompat.requireViewById(this, R.id.lblAvatar);
        imgAvatar = ActivityCompat.requireViewById(this, R.id.imgAvatar);
        TextView lblName = ActivityCompat.requireViewById(this, R.id.lblName);
        txtName = ActivityCompat.requireViewById(this, R.id.txtName);
        TextView lblEmail = ActivityCompat.requireViewById(this, R.id.lblEmail);
        txtEmail = ActivityCompat.requireViewById(this, R.id.txtEmail);
        imgEmail = ActivityCompat.requireViewById(this, R.id.imgEmail);
        TextView lblAddress = ActivityCompat.requireViewById(this, R.id.lblAddress);
        txtAddress = ActivityCompat.requireViewById(this, R.id.txtAddress);
        imgAddress = ActivityCompat.requireViewById(this, R.id.imgAddress);
        TextView lblPhonenumber = ActivityCompat.requireViewById(this, R.id.lblPhonenumber);
        txtPhonenumber = ActivityCompat.requireViewById(this, R.id.txtPhonenumber);
        imgPhonenumber = ActivityCompat.requireViewById(this, R.id.imgPhonenumber);
        TextView lblWeb = ActivityCompat.requireViewById(this, R.id.lblWeb);
        txtWeb = ActivityCompat.requireViewById(this, R.id.txtWeb);
        imgWeb = ActivityCompat.requireViewById(this, R.id.imgWeb);

        //Initially
        lblName.setTypeface(Typeface.DEFAULT_BOLD);
        txtName.requestFocus();
        imgAvatar.setImageResource(Database.getInstance().getDefaultAvatar().getImageResId());
        lblAvatar.setText(Database.getInstance().getDefaultAvatar().getName());

        //test
        imgAvatar.setTag(Database.getInstance().getDefaultAvatar().getImageResId());

        imgAvatar.setOnClickListener(l -> changeProfile());
        lblAvatar.setOnClickListener(l -> changeProfile());

        txtName.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) lblName.setTypeface(Typeface.DEFAULT);
            else lblName.setTypeface(Typeface.DEFAULT_BOLD);
        });

        txtEmail.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) lblEmail.setTypeface(Typeface.DEFAULT);
            else lblEmail.setTypeface(Typeface.DEFAULT_BOLD);
        });
        txtAddress.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) lblAddress.setTypeface(Typeface.DEFAULT);
            else lblAddress.setTypeface(Typeface.DEFAULT_BOLD);
        });
        txtPhonenumber.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) lblPhonenumber.setTypeface(Typeface.DEFAULT);
            else lblPhonenumber.setTypeface(Typeface.DEFAULT_BOLD);
        });
        txtWeb.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) lblWeb.setTypeface(Typeface.DEFAULT);
            else lblWeb.setTypeface(Typeface.DEFAULT_BOLD);
        });

        txtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkFieldSimple(txtName);
            }
        });

        txtAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkField(txtAddress, imgAddress, Field.ADDRESS);
            }
        });

        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkField(txtEmail, imgEmail, Field.EMAIL);
            }
        });

        txtPhonenumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkField(txtPhonenumber, imgPhonenumber, Field.PHONENUMBER);
            }
        });

        txtWeb.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkField(txtWeb, imgWeb, Field.WEB);


            }
        });

        txtWeb.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                save();
                return true;
            }
            return false;
        });

    }

    private void changeProfile() {
        Avatar avatar = Database.getInstance().getRandomAvatar();
        imgAvatar.setImageResource(avatar.getImageResId());
        //test
        imgAvatar.setTag(avatar.getImageResId());
        lblAvatar.setText(avatar.getName());
    }

    private boolean checkFieldSimple(EditText editText) {
        boolean isValid;
        if (!ValidationUtils.isEmptyText(editText.getText().toString())) {
            editText.setError(getString(R.string.main_invalid_data));
            isValid = false;
        } else {
            isValid = true;
        }
        return isValid;
    }

    private boolean checkField(EditText txt, ImageView imageView, Field field) {
        boolean isValid;
        if (field == Field.EMAIL && !ValidationUtils.isValidEmail(txt.getText().toString())) {
            isValid = invalidateField(txt, imageView);

        } else if (field == Field.PHONENUMBER && !ValidationUtils.isValidPhone(txt.getText().toString())) {
            isValid = invalidateField(txt, imageView);

        } else if (field == Field.WEB && !ValidationUtils.isValidUrl(txt.getText().toString())) {
            isValid = invalidateField(txt, imageView);

        } else if (field == Field.ADDRESS && !ValidationUtils.isEmptyText(txt.getText().toString())) {
            isValid = invalidateField(txt, imageView);

        } else {
            imageView.setEnabled(true);
            isValid = true;
        }
        return isValid;
    }

    private boolean invalidateField(EditText txt, ImageView imageView) {
        txt.setError(getString(R.string.main_invalid_data));
        imageView.setEnabled(false);
        return false;
    }

    /**
     * Checks if form is valid or not and shows a Snackbar accordingly
     **/

    private void save() {
        if (checkFieldSimple(txtName) && checkField(txtAddress, imgAddress, Field.ADDRESS) && checkField(txtPhonenumber, imgPhonenumber, Field.PHONENUMBER)
                && checkField(txtEmail, imgEmail, Field.EMAIL) && checkField(txtWeb, imgWeb, Field.WEB)) {
            KeyboardUtils.hideSoftKeyboard(this);
            SnackbarUtils.snackbar(imgAvatar, getString(R.string.main_saved_succesfully));
        } else {
            SnackbarUtils.snackbar(imgAvatar, getString(R.string.main_error_saving));
            checkField(txtAddress, imgAddress, Field.ADDRESS);
            checkField(txtPhonenumber, imgPhonenumber, Field.PHONENUMBER);
            checkField(txtEmail, imgEmail, Field.EMAIL);
            checkField(txtWeb, imgWeb, Field.WEB);
            KeyboardUtils.hideSoftKeyboard(this);
        }

    }

}
