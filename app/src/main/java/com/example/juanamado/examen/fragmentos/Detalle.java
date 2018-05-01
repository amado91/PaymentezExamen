package com.example.juanamado.examen.fragmentos;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.juanamado.examen.R;
import com.example.juanamado.examen.adapters.DetailAdapter;
import com.example.juanamado.examen.modelos.DetalleProducto;
import com.example.juanamado.examen.modelos.LugaresEncontrados;

import java.util.ArrayList;

public class Detalle extends Fragment implements View.OnClickListener{

    private Button back,compartir;
    private ListView product;
    private ImageView portada;
    private TextView name,address;
    private String names,adreesss;
    private ArrayList<LugaresEncontrados> detalle = new ArrayList<LugaresEncontrados>();
    private ArrayList<DetalleProducto> allProduct = new ArrayList<DetalleProducto>();


    public Detalle(){

    }


    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getAdreesss() {
        return adreesss;
    }

    public void setAdreesss(String adreesss) {
        this.adreesss = adreesss;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = null;

        if (v == null)
            v = inflater.inflate(R.layout.detail_fragment_layout, null);

        initUI(v);
        writeDetail();

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void initUI(View v){
     back    = v.findViewById(R.id.backDash);
     product = v.findViewById(R.id.list_item);
     name    = v.findViewById(R.id.name);
     address = v.findViewById(R.id.addres);
     compartir= v.findViewById(R.id.compartir);

     name.setText(getNames());
     address.setText(getAdreesss());

     back.setOnClickListener(this);
     compartir.setOnClickListener(this);

     Toolbar toolbar = v.findViewById(R.id.toolbar);
        //set toolbar appearance
        toolbar.setBackground(getResources().getDrawable(R.color.back_btn));
        toolbar.setTitleTextColor(getResources().getColor(R.color.whiteColor));
        toolbar.setTitle("       Detalle Producto");
    }

    @Override
    public void onClick(View v) {
        if (v == back){
            FragmentManager fm = getActivity().getSupportFragmentManager();
            if (fm.getBackStackEntryCount() > 0) {
                fm.popBackStack();
            }
        }

        if (v == compartir) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Prueba en Facebook");
            intent.setPackage("com.facebook.katana");
            startActivity(intent);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void writeDetail(){

        DetalleProducto detalleProducto = new DetalleProducto();
        detalleProducto.setImagen(getContext().getDrawable(R.drawable.pepsi));
        detalleProducto.setName("Pepsi");
        detalleProducto.setPrecio("$ 30.00");
        allProduct.add(detalleProducto);

        detalleProducto = new DetalleProducto();
        detalleProducto.setImagen(getContext().getDrawable(R.drawable.ensalada));
        detalleProducto.setName("Ensalda");
        detalleProducto.setPrecio("$ 100.00");
        allProduct.add(detalleProducto);

        detalleProducto = new DetalleProducto();
        detalleProducto.setImagen(getContext().getDrawable(R.drawable.pastel));
        detalleProducto.setName("Pastel");
        detalleProducto.setPrecio("$ 50.00");
        allProduct.add(detalleProducto);

        detalleProducto = new DetalleProducto();
        detalleProducto.setImagen(getContext().getDrawable(R.drawable.helado));
        detalleProducto.setName("Helado");
        detalleProducto.setPrecio("$ 50.00");
        allProduct.add(detalleProducto);

        detalleProducto = new DetalleProducto();
        detalleProducto.setImagen(getContext().getDrawable(R.drawable.cafe));
        detalleProducto.setName("Cafe");
        detalleProducto.setPrecio("$ 60.00");
        allProduct.add(detalleProducto);

        detalleProducto = new DetalleProducto();
        detalleProducto.setImagen(getContext().getDrawable(R.drawable.carne));
        detalleProducto.setName("Carne");
        detalleProducto.setPrecio("$ 150.00");
        allProduct.add(detalleProducto);

        detalleProducto = new DetalleProducto();
        detalleProducto.setImagen(getContext().getDrawable(R.drawable.pasta));
        detalleProducto.setName("Pasta");
        detalleProducto.setPrecio("$ 100.00");
        allProduct.add(detalleProducto);

        DetailAdapter detailAdapter = new DetailAdapter(getContext(),allProduct);
        product.setAdapter(detailAdapter);
    }

    @SuppressLint("ValidFragment")
    public Detalle (ArrayList<LugaresEncontrados> lugaresEncontrados,int id){

        Log.e("name",lugaresEncontrados.get(id).getName());
        Log.e("addrees",lugaresEncontrados.get(id).getAddress());
        setNames(lugaresEncontrados.get(id).getName());
        setAdreesss(lugaresEncontrados.get(id).getAddress());
    }
}
