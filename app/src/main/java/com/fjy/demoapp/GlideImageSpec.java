package com.fjy.demoapp;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.Size;
import com.facebook.litho.SizeSpec;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnMeasure;
import com.facebook.litho.annotations.OnMount;
import com.facebook.litho.annotations.OnUnmount;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.PropDefault;
import com.facebook.litho.annotations.ResType;
import com.facebook.litho.utils.MeasureUtils;

import java.io.File;

import static com.facebook.litho.annotations.ResType.DRAWABLE;

@MountSpec
public class GlideImageSpec {

  private static final String TAG = "GlideImageSpec";

  private static final int DEFAULT_INT_VALUE = -1;

  @PropDefault
  protected static final float imageAspectRatio = 1f;

  /*@PropDefault
  protected static final int crossFadeDuration = DEFAULT_INT_VALUE;*/

  @OnMeasure
  static void onMeasureLayout(ComponentContext c, ComponentLayout layout, int widthSpec,
                              int heightSpec, Size size,
                              @Prop(optional = true, resType = ResType.FLOAT) float imageAspectRatio) {
    MeasureUtils.measureWithAspectRatio(widthSpec, heightSpec, imageAspectRatio, size);
    Log.d(TAG, "onMeasureLayout() called with: c = [" + c + "], layout = [" + layout + "], widthSpec = [" + widthSpec + "], heightSpec = [" + heightSpec + "], size = [" + size + "], imageAspectRatio = [" + imageAspectRatio + "]");
//    // If width is undefined, set default size.
//    if (SizeSpec.getMode(widthSpec) == SizeSpec.UNSPECIFIED) {
//      size.width = 40;
//    } else {
//      size.width = SizeSpec.getSize(widthSpec);
//    }
//
//    // If height is undefined, use 1.5 aspect ratio.
//    if (SizeSpec.getMode(heightSpec) == SizeSpec.UNSPECIFIED) {
//      size.height = width * 1.5;
//    } else {
//      size.height = SizeSpec.getSize(heightSpec);
//    }
  }

  @OnCreateMountContent
  static ImageView onCreateMountContent(ComponentContext c) {
    return new ImageView(c.getBaseContext());
  }

  @OnMount
  static void onMount(ComponentContext c, ImageView imageView,
                      @Prop(optional = true) String imageUrl, @Prop(optional = true) File file,
                      @Prop(optional = true) Uri uri, @Prop(optional = true) Integer resourceId,
                      @Prop(optional = true) RequestManager glideRequestManager,
                      @Prop(optional = true, resType = DRAWABLE) Drawable failureImage,
                      @Prop(optional = true, resType = DRAWABLE) Drawable fallbackImage,
                      @Prop(optional = true, resType = DRAWABLE) Drawable placeholderImage,
                      @Prop(optional = true) DiskCacheStrategy diskCacheStrategy,
                      @Prop(optional = true) RequestListener requestListener,
                      @Prop(optional = true) boolean asBitmap, @Prop(optional = true) boolean asGif,
                      /*@Prop(optional = true) boolean crossFade, *//*@Prop(optional = true) int crossFadeDuration,*/
                      @Prop(optional = true) boolean centerCrop, @Prop(optional = true) boolean fitCenter,
                      @Prop(optional = true) boolean skipMemoryCache, @Prop(optional = true) Target target) {

    if (imageUrl == null && file == null && uri == null && resourceId == null) {
      throw new IllegalArgumentException(
          "You must provide at least one of String, File, Uri or ResourceId");
    }

    if (glideRequestManager == null) {
      glideRequestManager = Glide.with(c.getBaseContext());
    }

    RequestBuilder<Drawable> requestBuilder;

    if (imageUrl != null) {
      requestBuilder = glideRequestManager.load(imageUrl);
    } else if (file != null) {
      requestBuilder = glideRequestManager.load(file);
    } else if (uri != null) {
      requestBuilder = glideRequestManager.load(uri);
    } else {
      requestBuilder = glideRequestManager.load(resourceId);
    }

    if (requestBuilder == null) {
      throw new IllegalStateException("Could not instantiate DrawableTypeRequest");
    }

    RequestOptions requestOptions = new RequestOptions();
    if (diskCacheStrategy != null) {
      requestOptions.diskCacheStrategy(diskCacheStrategy);
    }

    if (asBitmap) {
      glideRequestManager.asBitmap();
    }

    if (asGif) {
      glideRequestManager.asGif();
    }

//    if (crossFade) {
//      glideRequestManager.crossFade();
//    }

//    if (crossFadeDuration != DEFAULT_INT_VALUE) {
//      requestBuilder.crossFade(crossFadeDuration);
//    }

    if (centerCrop) {
      requestOptions.centerCrop();
    }

    if (failureImage != null) {
      requestOptions.error(failureImage);
    }

    if (fallbackImage != null) {
      requestOptions.fallback(fallbackImage);
    }

    if (fitCenter) {
      requestOptions.fitCenter();
    }
    
    if (placeholderImage != null) {
      requestOptions.placeholder(placeholderImage);
    }

    requestOptions.skipMemoryCache(skipMemoryCache);

    requestBuilder.apply(requestOptions);

    if (requestListener != null) {
      requestBuilder.listener(requestListener);
    }
    if (target != null) {
      requestBuilder.into(target);
    } else {
      requestBuilder.into(imageView);
    }
  }

  @OnUnmount
  static void onUnmount(ComponentContext c, ImageView imageView) {
    Glide.with(c).clear(imageView);
  }
}