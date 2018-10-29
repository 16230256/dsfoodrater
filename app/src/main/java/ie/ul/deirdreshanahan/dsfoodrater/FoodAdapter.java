package ie.ul.deirdreshanahan.dsfoodrater;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    public void addFood(){

    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class FoodViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mName;
        private RatingBar mRatingBar;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.food_pic);
            mName = itemView.findViewById(R.id.name);
            mRatingBar = itemView.findViewById(R.id.rating_bar);

        }
    }
}
