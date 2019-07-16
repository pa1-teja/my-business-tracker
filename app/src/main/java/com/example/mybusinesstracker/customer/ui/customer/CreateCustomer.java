package com.example.mybusinesstracker.customer.ui.customer;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.databinding.DataBindingUtil;

import com.example.mybusinesstracker.BaseCalsses.BaseFragment;
import com.example.mybusinesstracker.R;
import com.example.mybusinesstracker.customer.CustomerFragmentInteractionListener;
import com.example.mybusinesstracker.databinding.FragmentCreateCustomerBinding;


public class CreateCustomer extends BaseFragment implements View.OnClickListener {
    private static final String ARG_CUSTOMER = "customer";

    private Customer mCustomer;

    private CustomerFragmentInteractionListener mListener;

    public CreateCustomer() {
        // Required empty public constructor
    }
    FragmentCreateCustomerBinding binding;
    public static CreateCustomer newInstance(Customer param1) {
        CreateCustomer fragment = new CreateCustomer();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CUSTOMER, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCustomer = (Customer) getArguments().getSerializable(ARG_CUSTOMER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_customer, container, false);
        View view = binding.getRoot();
        if(null == mCustomer) {
            binding.setCustomer(new Customer());
        } else {
            binding.setCustomer(mCustomer);
            view.findViewById(R.id.delete_customer).setVisibility(View.VISIBLE);
            view.findViewById(R.id.delete_customer).setOnClickListener(this);
            ((Button)view.findViewById(R.id.insert_customer)).setText(getString(R.string.cus_update_btn));
        }
        view.findViewById(R.id.insert_customer).setOnClickListener(this);
        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CustomerFragmentInteractionListener) {
            mListener = (CustomerFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement CustomerFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert_customer:
                mListener.createCustomer(binding.getCustomer(), this);
                break;
            case R.id.delete_customer:
                mListener.deleteCustomer(binding.getCustomer(), this);
                break;
        }
    }
}
