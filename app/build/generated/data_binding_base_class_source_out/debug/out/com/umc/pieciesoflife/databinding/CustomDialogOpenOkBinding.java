// Generated by view binder compiler. Do not edit!
package com.umc.pieciesoflife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public final class CustomDialogOpenOkBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnOk;

  @NonNull
  public final TextView tvMenuDelete;

  private CustomDialogOpenOkBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnOk,
      @NonNull TextView tvMenuDelete) {
    this.rootView = rootView;
    this.btnOk = btnOk;
    this.tvMenuDelete = tvMenuDelete;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CustomDialogOpenOkBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CustomDialogOpenOkBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.custom_dialog_open_ok, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CustomDialogOpenOkBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_ok;
      Button btnOk = ViewBindings.findChildViewById(rootView, id);
      if (btnOk == null) {
        break missingId;
      }

      id = R.id.tv_menu_delete;
      TextView tvMenuDelete = ViewBindings.findChildViewById(rootView, id);
      if (tvMenuDelete == null) {
        break missingId;
      }

      return new CustomDialogOpenOkBinding((ConstraintLayout) rootView, btnOk, tvMenuDelete);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
