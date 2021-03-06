package com.example.modul_spp_ukk2021.UI;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.modul_spp_ukk2021.R;
import com.example.modul_spp_ukk2021.UI.Data.Model.Pembayaran;
import com.google.android.material.card.MaterialCardView;

import java.text.DateFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class HistorySiswaAdapter extends RecyclerView.Adapter<HistorySiswaAdapter.ViewHolder> {
    private Context context;
    private List<Pembayaran> pembayaran;

    public HistorySiswaAdapter(Context context, List<Pembayaran> pembayaran) {
        this.context = context;
        this.pembayaran = pembayaran;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.container_data_tagihan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pembayaran pembayaran = this.pembayaran.get(position);

        holder.tvStatus.setText(pembayaran.getStatus_bayar());

        Locale localeID = new Locale("in", "ID");
        NumberFormat format = NumberFormat.getCurrencyInstance(localeID);
        format.setMaximumFractionDigits(0);

        DateFormatSymbols symbols = new DateFormatSymbols(localeID);
        String[] monthNames = symbols.getMonths();
        holder.tvBulan.setText(monthNames[pembayaran.getBulan_bayar() - 1]);

        holder.tvNominal.setText("+" + format.format(pembayaran.getNominal()));

        if (pembayaran.getTgl_bayar() != null) {
            SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy", localeID);
            String strDt = simpleDate.format(pembayaran.getTgl_bayar());
            holder.tvTanggal.setText(strDt);
        } else {
            holder.tvTanggal.setText("--/--/----");
        }
    }

    @Override
    public int getItemCount() {
        return pembayaran.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView materialCardView;
        TextView tvBulan, tvNominal, tvStatus, tvTanggal;

        public ViewHolder(View itemView) {
            super(itemView);
            tvStatus = itemView.findViewById(R.id.textView2);
            tvBulan = itemView.findViewById(R.id.textView);
            tvNominal = itemView.findViewById(R.id.textView19);
            tvTanggal = itemView.findViewById(R.id.textView3);
            materialCardView = itemView.findViewById(R.id.card);
        }
    }
}
