/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.platform.pricer.impl.swap;

import static com.opengamma.collect.TestHelper.assertThrowsIllegalArg;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.opengamma.platform.finance.swap.PaymentPeriod;
import com.opengamma.platform.finance.swap.RatePaymentPeriod;
import com.opengamma.platform.pricer.PricingEnvironment;
import com.opengamma.platform.pricer.swap.PaymentPeriodPricerFn;

/**
 * Test.
 */
@Test
public class DispatchingPaymentPeriodPricerFnTest {

  private final PricingEnvironment mockEnv = mock(PricingEnvironment.class);

  public void test_presentValue_RatePaymentPeriod() {
    double expected = 0.0123d;
    PaymentPeriodPricerFn<RatePaymentPeriod> mockNotionalExchangeFn = mock(PaymentPeriodPricerFn.class);
    when(mockNotionalExchangeFn.presentValue(mockEnv, SwapDummyData.FIXED_RATE_PAYMENT_PERIOD))
        .thenReturn(expected);
    DispatchingPaymentPeriodPricerFn test = new DispatchingPaymentPeriodPricerFn(mockNotionalExchangeFn);
    assertEquals(test.presentValue(mockEnv, SwapDummyData.FIXED_RATE_PAYMENT_PERIOD), expected, 0d);
  }

  public void test_presentValue_unknownType() {
    PaymentPeriod mockPaymentPeriod = mock(PaymentPeriod.class);
    DispatchingPaymentPeriodPricerFn test = DispatchingPaymentPeriodPricerFn.DEFAULT;
    assertThrowsIllegalArg(() -> test.presentValue(mockEnv, mockPaymentPeriod));
  }

  //-------------------------------------------------------------------------
  public void test_futureValue_RatePaymentPeriod() {
    double expected = 0.0123d;
    PaymentPeriodPricerFn<RatePaymentPeriod> mockNotionalExchangeFn = mock(PaymentPeriodPricerFn.class);
    when(mockNotionalExchangeFn.futureValue(mockEnv, SwapDummyData.FIXED_RATE_PAYMENT_PERIOD))
        .thenReturn(expected);
    DispatchingPaymentPeriodPricerFn test = new DispatchingPaymentPeriodPricerFn(mockNotionalExchangeFn);
    assertEquals(test.futureValue(mockEnv, SwapDummyData.FIXED_RATE_PAYMENT_PERIOD), expected, 0d);
  }

  public void test_futureValue_unknownType() {
    PaymentPeriod mockPaymentPeriod = mock(PaymentPeriod.class);
    DispatchingPaymentPeriodPricerFn test = DispatchingPaymentPeriodPricerFn.DEFAULT;
    assertThrowsIllegalArg(() -> test.futureValue(mockEnv, mockPaymentPeriod));
  }

}