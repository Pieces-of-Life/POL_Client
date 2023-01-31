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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.umc.pieciesoflife.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityStartNewstoryBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton buttonBack;

  @NonNull
  public final Button buttonGuide;

  @NonNull
  public final Button buttonReady;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView10;

  @NonNull
  public final TextView textView11;

  @NonNull
  public final TextView textView12;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView textView9;

  private ActivityStartNewstoryBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageButton buttonBack, @NonNull Button buttonGuide, @NonNull Button buttonReady,
      @NonNull TextView textView, @NonNull TextView textView10, @NonNull TextView textView11,
      @NonNull TextView textView12, @NonNull TextView textView2, @NonNull TextView textView3,
      @NonNull TextView textView4, @NonNull TextView textView6, @NonNull TextView textView9) {
    this.rootView = rootView;
    this.buttonBack = buttonBack;
    this.buttonGuide = buttonGuide;
    this.buttonReady = buttonReady;
    this.textView = textView;
    this.textView10 = textView10;
    this.textView11 = textView11;
    this.textView12 = textView12;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.textView6 = textView6;
    this.textView9 = textView9;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityStartNewstoryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityStartNewstoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_start_newstory, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityStartNewstoryBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_back;
      ImageButton buttonBack = ViewBindings.findChildViewById(rootView, id);
      if (buttonBack == null) {
        break missingId;
      }

      id = R.id.button_guide;
      Button buttonGuide = ViewBindings.findChildViewById(rootView, id);
      if (buttonGuide == null) {
        break missingId;
      }

      id = R.id.button_ready;
      Button buttonReady = ViewBindings.findChildViewById(rootView, id);
      if (buttonReady == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView10;
      TextView textView10 = ViewBindings.findChildViewById(rootView, id);
      if (textView10 == null) {
        break missingId;
      }

      id = R.id.textView11;
      TextView textView11 = ViewBindings.findChildViewById(rootView, id);
      if (textView11 == null) {
        break missingId;
      }

      id = R.id.textView12;
      TextView textView12 = ViewBindings.findChildViewById(rootView, id);
      if (textView12 == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = ViewBindings.findChildViewById(rootView, id);
      if (textView9 == null) {
        break missingId;
      }

      return new ActivityStartNewstoryBinding((ConstraintLayout) rootView, buttonBack, buttonGuide,
          buttonReady, textView, textView10, textView11, textView12, textView2, textView3,
          textView4, textView6, textView9);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
