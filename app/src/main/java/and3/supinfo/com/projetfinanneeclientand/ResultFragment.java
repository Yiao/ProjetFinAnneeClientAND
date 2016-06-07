package and3.supinfo.com.projetfinanneeclientand;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {

    private List<Map<String, Object>> mData;

    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mData = getData();
        ListView lv = (ListView) getActivity().findViewById(R.id.lv_result);
        lv.setAdapter(new MyListAdaper(this ,R.layout.list_item, mData));
    }

    private List<Map<String, Object>>  getData(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> element1 =  new HashMap<String, Object>();
        element1.put("arrivalText","Paris");
        element1.put("departText","Orleans");
        element1.put("dateText","13/06/2016");
        element1.put("prixText","21$");
        list.add(element1);

        Map<String, Object> element2 =  new HashMap<String, Object>();
        element2.put("arrivalText","Beijing");
        element2.put("departText","Orleans");
        element2.put("dateText","20/06/2016");
        element2.put("prixText","10$");
        list.add(element2);

        Map<String, Object> element3 =  new HashMap<String, Object>();
        element3.put("arrivalText","Nante");
        element3.put("departText","Orleans");
        element3.put("dateText","5/06/2016");
        element3.put("prixText","10$");
        list.add(element3);

        Map<String, Object> element4 =  new HashMap<String, Object>();
        element4.put("arrivalText","Turc");
        element4.put("departText","Orleans");
        element4.put("dateText","7/06/2016");
        element4.put("prixText","12$");
        list.add(element4);

        return  list;
    }
    private class MyListAdaper extends ArrayAdapter<Map<String, Object>>{
        private int layout;
        public MyListAdaper(ResultFragment context, int resource, List<Map<String, Object>> objects) {
            super(context.getActivity(), resource, objects);
            layout = resource;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolader mainViewholder = null;

            if(convertView==null)
            {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout,parent,false);
                mainViewholder = new ViewHolader();
                mainViewholder.thumbnail = (ImageView) convertView.findViewById(R.id.list_item_thubnail);
                mainViewholder.arrival = (TextView) convertView.findViewById(R.id.list_item_arrival);
                mainViewholder.arrivalText = (TextView) convertView.findViewById(R.id.list_item_arrival_text);
                mainViewholder.depart = (TextView) convertView.findViewById(R.id.list_item_depart);
                mainViewholder.departText = (TextView) convertView.findViewById(R.id.list_item_depart_text);
                mainViewholder.button = (Button) convertView.findViewById(R.id.list_item_add);
                mainViewholder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(),"Button was clicked for list item "+ position, Toast.LENGTH_SHORT).show();
                    }
                });
                mainViewholder.dateText = (TextView) convertView.findViewById(R.id.list_item_date);
                mainViewholder.prixText = (TextView) convertView.findViewById(R.id.list_item_prix);

                convertView.setTag(mainViewholder);
            }
            else{
                mainViewholder = (ViewHolader) convertView.getTag();
            }

            mainViewholder.arrivalText.setText((String)mData.get(position).get("arrivalText"));
            mainViewholder.departText.setText((String)mData.get(position).get("departText"));
            mainViewholder.dateText.setText((String)mData.get(position).get("dateText"));
            mainViewholder.prixText.setText((String)mData.get(position).get("prixText"));


            return convertView;
        }
    }

    private class ViewHolader{
        ImageView thumbnail;
        TextView arrival;
        TextView arrivalText;
        TextView depart;
        TextView departText;
        TextView dateText;
        Button button;
        TextView prixText;

    }
}
