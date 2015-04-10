package com.example.test;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class DragLayout extends RelativeLayout {

	private final ViewDragHelper mDragHelper;

	final ViewDragHelper.Callback mDragCallBack = new ViewDragHelper.Callback() {
		@Override
		public int clampViewPositionHorizontal(View child, int left, int dx) {
			return left;
		};

		@Override
		public int clampViewPositionVertical(View child, int top, int dy) {
			return top;
		};

		@Override
		public void onViewPositionChanged(View changedView, int left, int top,
				int dx, int dy) {
			invalidate();
		}

		@Override
		public boolean tryCaptureView(View arg0, int arg1) {
			return true;
		}
	};

	public DragLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		mDragHelper = ViewDragHelper.create(this, 1.0f, mDragCallBack);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return mDragHelper.shouldInterceptTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		mDragHelper.processTouchEvent(event);
		return true;
	}

}
