package and3.supinfo.com.projetfinanneeclientand;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        Button bt_login = (Button) getActivity().findViewById(R.id.login_button);
        // Inflate the layout for this fragment

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText username = (EditText) getActivity().findViewById(R.id.username);
                final EditText password = (EditText) getActivity().findViewById(R.id.password);
                final String s_username = username.getText().toString();
                final String s_password = password.getText().toString();



                if(s_username.equals("admin")&&s_password.equals("admin"))
                {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_container, new SearchFragment());
                    ft.commit();

                }
                else
                {
                    Toast.makeText(getContext(), "Check your username and password please", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
