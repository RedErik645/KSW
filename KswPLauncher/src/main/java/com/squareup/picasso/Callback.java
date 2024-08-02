package com.squareup.picasso;

public interface Callback {
    void onError();

    void onSuccess();

    public static class EmptyCallback implements Callback {
        @Override // com.squareup.picasso.Callback
        public void onSuccess() {
        }

        @Override // com.squareup.picasso.Callback
        public void onError() {
        }
    }
}
