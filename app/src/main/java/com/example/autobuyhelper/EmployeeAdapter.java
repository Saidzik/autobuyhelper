package com.example.autobuyhelper.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.autobuyhelper.R;
import com.example.autobuyhelper.models.Employee;
import java.util.List;
import java.util.Locale;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private List<Employee> employeeList;

    public EmployeeAdapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employeeList.get(position);

        holder.tvEmployeeName.setText(employee.getName());
        holder.tvSalesCount.setText(String.format(Locale.getDefault(),
                "%d продаж", employee.getSalesCount()));
        holder.tvTotalSales.setText(String.format(Locale.getDefault(),
                "%.0f ₽", employee.getTotalSales()));
        holder.tvPosition.setText(employee.getPosition());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView tvEmployeeName, tvSalesCount, tvTotalSales, tvPosition;
        CardView cardView;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEmployeeName = itemView.findViewById(R.id.tvEmployeeName);
            tvSalesCount = itemView.findViewById(R.id.tvSalesCount);
            tvTotalSales = itemView.findViewById(R.id.tvTotalSales);
            tvPosition = itemView.findViewById(R.id.tvPosition);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
