package com.example.nhom7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHoclear> {
    private List<OnboardingItem> onboardingItems;

    public OnboardingAdapter(List<OnboardingItem> onboardingItems) {
        this.onboardingItems = onboardingItems;
    }

    @NonNull
    @Override
    public OnboardingViewHoclear onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnboardingViewHoclear(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contener_onboarding,parent,false)
        );
    }


    @Override
    public void onBindViewHolder(@NonNull OnboardingViewHoclear holder, int position) {
        holder.setOnboardingData(onboardingItems.get(position));
    }


    @Override
    public int getItemCount() {
        return onboardingItems.size();
    }

    class OnboardingViewHoclear extends RecyclerView.ViewHolder{


        private ImageView imageOnboarding;

         OnboardingViewHoclear(@NonNull View itemView) {
            super(itemView);

            imageOnboarding = itemView.findViewById(R.id.imageOnboarding);

        }
        void setOnboardingData(OnboardingItem onboardingItem){

            imageOnboarding.setImageResource(onboardingItem.getImage());
        }
    }
}
