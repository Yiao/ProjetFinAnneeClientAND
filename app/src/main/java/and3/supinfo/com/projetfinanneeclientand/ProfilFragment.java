package and3.supinfo.com.projetfinanneeclientand;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {


    public ProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final EditText et_newUserName = (EditText) getActivity().findViewById(R.id.et_newUserName);
        final EditText et_newFirstName = (EditText) getActivity().findViewById(R.id.et_newFirstName);
        final EditText et_newLastName = (EditText) getActivity().findViewById(R.id.et_newLastName);
        final EditText et_newAge = (EditText) getActivity().findViewById(R.id.et_newAge);
        final EditText et_newPassword = (EditText) getActivity().findViewById(R.id.et_newPassword);
        final EditText et_oldPassword = (EditText) getActivity().findViewById(R.id.et_oldPassword);


        Button bt_sup_username = (Button) getActivity().findViewById(R.id.bt_sup_username);
        bt_sup_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_newUserName.getText().clear();
            }
        });
        Button bt_sup_firstname = (Button) getActivity().findViewById(R.id.bt_sup_firstname);
        bt_sup_firstname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_newFirstName.getText().clear();
            }
        });
        Button bt_sup_lastname = (Button) getActivity().findViewById(R.id.bt_sup_lastname);
        bt_sup_lastname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_newLastName.getText().clear();
            }
        });
        Button bt_sup_age = (Button) getActivity().findViewById(R.id.bt_sup_age);
        bt_sup_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_newAge.getText().clear();
            }
        });
        Button bt_sup_password = (Button) getActivity().findViewById(R.id.bt_sup_password);
        bt_sup_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_newPassword.getText().clear();
            }
        });
        Button bt_sup_oldpassword = (Button) getActivity().findViewById(R.id.bt_sup_oldpassword);
        bt_sup_oldpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_oldPassword.getText().clear();
            }
        });

    }
}
