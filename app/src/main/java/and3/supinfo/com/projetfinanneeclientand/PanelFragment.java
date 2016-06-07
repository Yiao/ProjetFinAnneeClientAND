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
public class PanelFragment extends Fragment {

    private List<Map<String, Object>> mData;

    public PanelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_panel, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mData = getData();
        ListView lvPanel = (ListView) getActivity().findViewById(R.id.lv_panel);
        lvPanel.setAdapter(new MyListAdaper(this ,R.layout.list_item_panel, mData));
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
        public MyListAdaper(PanelFragment context, int resource, List<Map<String, Object>> objects) {
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
                mainViewholder.panelthumbnail = (ImageView) convertView.findViewById(R.id.list_item_panel_thubnail);
                mainViewholder.panelarrival = (TextView) convertView.findViewById(R.id.list_item_panel_arrival);
                mainViewholder.panelarrivalText = (TextView) convertView.findViewById(R.id.list_item_panel_arrival_text);
                mainViewholder.paneldepart = (TextView) convertView.findViewById(R.id.list_item_panel_depart);
                mainViewholder.paneldepartText = (TextView) convertView.findViewById(R.id.list_item_panel_depart_text);
                mainViewholder.panelconfirmbuttom = (Button) convertView.findViewById(R.id.list_item_panel_confirm);
                mainViewholder.panelconfirmbuttom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(),"Confirm "+ position, Toast.LENGTH_SHORT).show();
                    }
                });

                mainViewholder.paneldeletebuttom = (Button) convertView.findViewById(R.id.list_item_panel_delete);
                mainViewholder.paneldeletebuttom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(),"Delete"+ position, Toast.LENGTH_SHORT).show();
                    }
                });
                mainViewholder.paneldateText = (TextView) convertView.findViewById(R.id.list_item_panel_date);
                mainViewholder.panelprixText = (TextView) convertView.findViewById(R.id.list_item_panel_prix);

                convertView.setTag(mainViewholder);
            }
            else{
                mainViewholder = (ViewHolader) convertView.getTag();
            }

            mainViewholder.panelarrivalText.setText((CharSequence) mData.get(position).get("arrivalText"));
            mainViewholder.paneldepartText.setText((CharSequence) mData.get(position).get("departText"));
            mainViewholder.panelprixText.setText((CharSequence) mData.get(position).get("prixText"));
            mainViewholder.paneldateText.setText((CharSequence)mData.get(position).get("dateText"));

            return convertView;
        }
    }

    private class ViewHolader{
        ImageView panelthumbnail;
        TextView panelarrival;
        TextView panelarrivalText;
        TextView paneldepart;
        TextView paneldepartText;
        TextView paneldateText;
        Button panelconfirmbuttom;
        TextView panelprixText;
        Button paneldeletebuttom;
    }
}
