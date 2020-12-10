package razerdp.design;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.RotateAnimation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import razerdp.basepopup.BasePopupWindow;
import razerdp.library.R;

public class MonthNewsPopup extends BasePopupWindow implements View.OnClickListener{


    public RecyclerView mRecyclerView;

    public interface DialogClickCallBack{
        void addClick();
    }
    private DialogClickCallBack mDialogClickCallBack;

    public void setDialogClickCallBack(DialogClickCallBack callBack){
        this.mDialogClickCallBack = callBack;
    }


    public MonthNewsPopup(Activity context) {
        super(context);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(new MonthAdapter());
    }

    public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.ViewHolder>{

        @NonNull
        @Override
        public MonthAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.month_adapter,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull MonthAdapter.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 3;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }

    @Override
    protected Animation initShowAnimation() {
        AnimationSet set=new AnimationSet(false);
        Animation shakeAnima=new RotateAnimation(0,15, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        shakeAnima.setInterpolator(new CycleInterpolator(5));
        shakeAnima.setDuration(400);
        set.addAnimation(getDefaultAlphaAnimation());
        set.addAnimation(shakeAnima);
        return set;
    }

    @Override
    public View getClickToDismissView() {
        return getPopupWindowView();
    }

    @Override
    public View onCreatePopupView() {
        return createPopupById(R.layout.month_news_layout);
    }

    @Override
    public View initAnimaView() {
        return findViewById(R.id.popup_anima);
    }

    @Override
    public void onClick(View v) {

    }
}
