package and3.supinfo.com.projetfinanneeclientand;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    // on instancie notre calendar et notre datepicker
    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener datepicker;
    TimePickerDialog.OnTimeSetListener timePickerDepart;
    TimePickerDialog.OnTimeSetListener timePickerArrive;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button bt_search = (Button) getActivity().findViewById(R.id.bt_search);
        EditText tv_getDepartTime = (EditText) getActivity().findViewById(R.id.tv_departTime);
        EditText tv_getArriveTime = (EditText) getActivity().findViewById(R.id.tv_arriveTime);
        EditText bt_getDepartDate = (EditText) getActivity().findViewById(R.id.tv_departDate);


        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new ResultFragment());
                ft.commit();
            }
        });

        // la partie datepicker pour afficher interface calendar
        datepicker = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateTextDate();
            }

        };

        bt_getDepartDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    new DatePickerDialog(getActivity(), datepicker,
                            myCalendar.get(Calendar.YEAR),
                            myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            }
        });

        // la partie depart time picker
        timePickerDepart = new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.HOUR_OF_DAY, hour);
                myCalendar.set(Calendar.MINUTE, minute);
                updateTextDepartTime();
            }
        };
        tv_getDepartTime.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    new TimePickerDialog(getActivity(), timePickerDepart,
                            myCalendar.get(Calendar.HOUR_OF_DAY),
                            myCalendar.get(Calendar.MINUTE), true).show();
                }
            }
        });

        // la partie arrive time picker
        timePickerArrive = new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.HOUR_OF_DAY, hour);
                myCalendar.set(Calendar.MINUTE, minute);
                updateTextArriveTime();
            }
        };
        tv_getArriveTime.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // TODO Auto-generated method stub
                    new TimePickerDialog(getActivity(), timePickerArrive,
                            myCalendar.get(Calendar.HOUR_OF_DAY),
                            myCalendar.get(Calendar.MINUTE), true).show();
                }
            }
        });
    }

    private void updateTextDate()
    {
        EditText tv_date = (EditText) getActivity().findViewById(R.id.tv_departDate);
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        tv_date.setText(sdf.format(myCalendar.getTime()));
    }

    private void updateTextDepartTime()
    {
        EditText tv_departTime = (EditText) getActivity().findViewById(R.id.tv_departTime);
        String myFormat = "HH:mm"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        tv_departTime.setText(sdf.format(myCalendar.getTime()));
    }

    private void   updateTextArriveTime()
    {
        EditText tv_arriveTime = (EditText) getActivity().findViewById(R.id.tv_arriveTime);
        String myFormat = "HH:mm"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        tv_arriveTime.setText(sdf.format(myCalendar.getTime()));
    }

}
