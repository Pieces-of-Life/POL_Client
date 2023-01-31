// Generated by view binder compiler. Do not edit!
package com.umc.pieciesoflife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.umc.pieciesoflife.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDetailedExploreBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton btnBack;

  @NonNull
  public final Button btnLikeDetailed;

  @NonNull
  public final ImageButton btnSend;

  @NonNull
  public final ConstraintLayout constraintLayout2;

  @NonNull
  public final CircleImageView ivCircle;

  @NonNull
  public final RecyclerView rvDetailed;

  @NonNull
  public final TextView tvContent;

  @NonNull
  public final TextView tvDate;

  @NonNull
  public final TextView tvNameDetailed;

  @NonNull
  public final TextView tvTitleDetailed;

  private ActivityDetailedExploreBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageButton btnBack, @NonNull Button btnLikeDetailed, @NonNull ImageButton btnSend,
      @NonNull ConstraintLayout constraintLayout2, @NonNull CircleImageView ivCircle,
      @NonNull RecyclerView rvDetailed, @NonNull TextView tvContent, @NonNull TextView tvDate,
      @NonNull TextView tvNameDetailed, @NonNull TextView tvTitleDetailed) {
    this.rootView = rootView;
    this.btnBack = btnBack;
    this.btnLikeDetailed = btnLikeDetailed;
    this.btnSend = btnSend;
    this.constraintLayout2 = constraintLayout2;
    this.ivCircle = ivCircle;
    this.rvDetailed = rvDetailed;
    this.tvContent = tvContent;
    this.tvDate = tvDate;
    this.tvNameDetailed = tvNameDetailed;
    this.tvTitleDetailed = tvTitleDetailed;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDetailedExploreBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDetailedExploreBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_detailed_explore, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDetailedExploreBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_back;
      ImageButton btnBack = ViewBindings.findChildViewById(rootView, id);
      if (btnBack == null) {
        break missingId;
      }

      id = R.id.btn_like_detailed;
      Button btnLikeDetailed = ViewBindings.findChildViewById(rootView, id);
      if (btnLikeDetailed == null) {
        break missingId;
      }

      id = R.id.btn_send;
      ImageButton btnSend = ViewBindings.findChildViewById(rootView, id);
      if (btnSend == null) {
        break missingId;
      }

      id = R.id.constraintLayout2;
      ConstraintLayout constraintLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout2 == null) {
        break missingId;
      }

      id = R.id.iv_circle;
      CircleImageView ivCircle = ViewBindings.findChildViewById(rootView, id);
      if (ivCircle == null) {
        break missingId;
      }

      id = R.id.rv_detailed;
      RecyclerView rvDetailed = ViewBindings.findChildViewById(rootView, id);
      if (rvDetailed == null) {
        break missingId;
      }

      id = R.id.tv_content;
      TextView tvContent = ViewBindings.findChildViewById(rootView, id);
      if (tvContent == null) {
        break missingId;
      }

      id = R.id.tv_date;
      TextView tvDate = ViewBindings.findChildViewById(rootView, id);
      if (tvDate == null) {
        break missingId;
      }

      id = R.id.tv_name_detailed;
      TextView tvNameDetailed = ViewBindings.findChildViewById(rootView, id);
      if (tvNameDetailed == null) {
        break missingId;
      }

      id = R.id.tv_title_detailed;
      TextView tvTitleDetailed = ViewBindings.findChildViewById(rootView, id);
      if (tvTitleDetailed == null) {
        break missingId;
      }

      return new ActivityDetailedExploreBinding((ConstraintLayout) rootView, btnBack,
          btnLikeDetailed, btnSend, constraintLayout2, ivCircle, rvDetailed, tvContent, tvDate,
          tvNameDetailed, tvTitleDetailed);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
