package ie.ul.deirdreshanahan.dsfoodrater;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends
        RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    //left out by deirdre
    @NonNull
    @Override
    public  FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_item_view, parent, false);
        return new FoodViewHolder(itemView);
    }
    //end of left out by deirdre
    private List<Food> mFoods = new ArrayList<>();
    private RecyclerView mRecyclerView;

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }


    public void addFood() {
        mFoods.add(0, new Food());
        notifyItemInserted(0);
        notifyItemRangeChanged(0, mFoods.size());
        mRecyclerView.getLayoutManager().scrollToPosition(1);
        }
        private void deleteFood(int position) {
        mFoods.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(0,mFoods.size());
        }


    @Override
    public int getItemCount()
        {
            return mFoods.size();
    }
@Override
public void onBindViewHolder(@NonNull FoodViewHolder holder , int position) {
        final Food food = mFoods.get(position);
        holder.mName.setText(food.getName());
        holder.mImageView.setImageResource(food.getImageResourceId());
        holder.mRatingBar.setRating(food.getRating());
}

    class FoodViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mName;
        private RatingBar mRatingBar;
        public FoodViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.food_pic);
            mName = itemView.findViewById(R.id.name);
            mRatingBar = itemView.findViewById(R.id.rating_bar);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    deleteFood(getAdapterPosition());
                    return true;
                }
            });
            mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    if (fromUser) {
                        mFoods.get(getAdapterPosition()).setRating(rating);
                    }
                }
            });
                    }
    }
}
