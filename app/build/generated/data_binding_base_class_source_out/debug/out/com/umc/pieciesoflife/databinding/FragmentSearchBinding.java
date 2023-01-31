// Generated by view binder compiler. Do not edit!
package com.umc.pieciesoflife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.umc.pieciesoflife.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSearchBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton btnNoti;

  @NonNull
  public final ImageButton btnProfile;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final ConstraintLayout layoutEx2;

  @NonNull
  public final RecyclerView rvExplore;

  @NonNull
  public final TextView tvAlignLike;

  @NonNull
  public final TextView tvAlignNew;

  @NonNull
  public final TextView tvExplore;

  @NonNull
  public final TextView tvPol;

  @NonNull
  public final View view2;

  private FragmentSearchBinding(@NonNull ConstraintLayout rootView, @NonNull ImageButton btnNoti,
      @NonNull ImageButton btnProfile, @NonNull ConstraintLayout constraintLayout,
      @NonNull ConstraintLayout layoutEx2, @NonNull RecyclerView rvExplore,
      @NonNull TextView tvAlignLike, @NonNull TextView tvAlignNew, @NonNull TextView tvExplore,
      @NonNull TextView tvPol, @NonNull View view2) {
    this.rootView = rootView;
    this.btnNoti = btnNoti;
    this.btnProfile = btnProfile;
    this.constraintLayout = constraintLayout;
    this.layoutEx2 = layoutEx2;
    this.rvExplore = rvExplore;
    this.tvAlignLike = tvAlignLike;
    this.tvAlignNew = tvAlignNew;
    this.tvExplore = tvExplore;
    this.tvPol = tvPol;
    this.view2 = view2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_search, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSearchBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_noti;
      ImageButton btnNoti = ViewBindings.findChildViewById(rootView, id);
      if (btnNoti == null) {
        break missingId;
      }

      id = R.id.btn_profile;
      ImageButton btnProfile = ViewBindings.findChildViewById(rootView, id);
      if (btnProfile == null) {
        break missingId;
      }

      ConstraintLayout constraintLayout = (ConstraintLayout) rootView;

      id = R.id.layout_ex2;
      ConstraintLayout layoutEx2 = ViewBindings.findChildViewById(rootView, id);
      if (layoutEx2 == null) {
        break missingId;
      }

      id = R.id.rv_explore;
      RecyclerView rvExplore = ViewBindings.findChildViewById(rootView, id);
      if (rvExplore == null) {
        break missingId;
      }

      id = R.id.tv_align_like;
      TextView tvAlignLike = ViewBindings.findChildViewById(rootView, id);
      if (tvAlignLike == null) {
        break missingId;
      }

      id = R.id.tv_align_new;
      TextView tvAlignNew = ViewBindings.findChildViewById(rootView, id);
      if (tvAlignNew == null) {
        break missingId;
      }

      id = R.id.tv_explore;
      TextView tvExplore = ViewBindings.findChildViewById(rootView, id);
      if (tvExplore == null) {
        break missingId;
      }

      id = R.id.tv_pol;
      TextView tvPol = ViewBindings.findChildViewById(rootView, id);
      if (tvPol == null) {
        break missingId;
      }

      id = R.id.view2;
      View view2 = ViewBindings.findChildViewById(rootView, id);
      if (view2 == null) {
        break missingId;
      }

      return new FragmentSearchBinding((ConstraintLayout) rootView, btnNoti, btnProfile,
          constraintLayout, layoutEx2, rvExplore, tvAlignLike, tvAlignNew, tvExplore, tvPol, view2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
