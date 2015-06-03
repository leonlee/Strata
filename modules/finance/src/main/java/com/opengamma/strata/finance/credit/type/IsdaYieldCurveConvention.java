package com.opengamma.strata.finance.credit.type;

import com.opengamma.strata.basics.currency.Currency;
import com.opengamma.strata.basics.date.BusinessDayAdjustment;
import com.opengamma.strata.basics.date.BusinessDayConvention;
import com.opengamma.strata.basics.date.DayCount;
import com.opengamma.strata.basics.date.HolidayCalendar;
import com.opengamma.strata.basics.schedule.Frequency;
import com.opengamma.strata.finance.Convention;
import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * See 3.3.1 in http://www.cdsmodel.com/assets/cds-model/docs/Interest%20Rate%20Curve%20-%20XML%20Specifications.pdf
 */
@BeanDefinition
public final class IsdaYieldCurveConvention
    implements Convention, ImmutableBean, Serializable {

  @PropertyDefinition(validate = "notNull")
  private final Currency currency;

  @PropertyDefinition(validate = "notNull")
  private final DayCount mmDayCount;

  @PropertyDefinition(validate = "notNull")
  private final DayCount fixedDayCount; // Floating leg values not used by the model

  @PropertyDefinition(validate = "notNull")
  private final DayCount curveDayCount;

  @PropertyDefinition(validate = "notNull")
  private final int spotDays;

  @PropertyDefinition(validate = "notNull")
  private final Frequency fixedPaymentFrequency; // Floating leg values not used by the model

  @PropertyDefinition(validate = "notNull")
  private final BusinessDayConvention badDayConvention;

  @PropertyDefinition(validate = "notNull")
  private final HolidayCalendar holidayCalendar;

  public static IsdaYieldCurveConvention of(
      Currency currency,
      DayCount mmDayCount,
      DayCount fixedDayCount,
      DayCount curveDayCount,
      int spotDays,
      Frequency fixedPaymentFrequency,
      BusinessDayConvention badDayConvention,
      HolidayCalendar holidayCalendar
  ) {
    return new IsdaYieldCurveConvention(
        currency,
        mmDayCount,
        fixedDayCount,
        curveDayCount,
        spotDays,
        fixedPaymentFrequency,
        badDayConvention,
        holidayCalendar
    );
  }

  public LocalDate getSpotDateAsOf(LocalDate asOfDate) {
    BusinessDayAdjustment adjustment = BusinessDayAdjustment.of(
        badDayConvention,
        holidayCalendar
    );
    return adjustment.adjust(asOfDate.plusDays(spotDays));
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code IsdaYieldCurveConvention}.
   * @return the meta-bean, not null
   */
  public static IsdaYieldCurveConvention.Meta meta() {
    return IsdaYieldCurveConvention.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(IsdaYieldCurveConvention.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static IsdaYieldCurveConvention.Builder builder() {
    return new IsdaYieldCurveConvention.Builder();
  }

  private IsdaYieldCurveConvention(
      Currency currency,
      DayCount mmDayCount,
      DayCount fixedDayCount,
      DayCount curveDayCount,
      int spotDays,
      Frequency fixedPaymentFrequency,
      BusinessDayConvention badDayConvention,
      HolidayCalendar holidayCalendar) {
    JodaBeanUtils.notNull(currency, "currency");
    JodaBeanUtils.notNull(mmDayCount, "mmDayCount");
    JodaBeanUtils.notNull(fixedDayCount, "fixedDayCount");
    JodaBeanUtils.notNull(curveDayCount, "curveDayCount");
    JodaBeanUtils.notNull(spotDays, "spotDays");
    JodaBeanUtils.notNull(fixedPaymentFrequency, "fixedPaymentFrequency");
    JodaBeanUtils.notNull(badDayConvention, "badDayConvention");
    JodaBeanUtils.notNull(holidayCalendar, "holidayCalendar");
    this.currency = currency;
    this.mmDayCount = mmDayCount;
    this.fixedDayCount = fixedDayCount;
    this.curveDayCount = curveDayCount;
    this.spotDays = spotDays;
    this.fixedPaymentFrequency = fixedPaymentFrequency;
    this.badDayConvention = badDayConvention;
    this.holidayCalendar = holidayCalendar;
  }

  @Override
  public IsdaYieldCurveConvention.Meta metaBean() {
    return IsdaYieldCurveConvention.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the currency.
   * @return the value of the property, not null
   */
  public Currency getCurrency() {
    return currency;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the mmDayCount.
   * @return the value of the property, not null
   */
  public DayCount getMmDayCount() {
    return mmDayCount;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the fixedDayCount.
   * @return the value of the property, not null
   */
  public DayCount getFixedDayCount() {
    return fixedDayCount;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the curveDayCount.
   * @return the value of the property, not null
   */
  public DayCount getCurveDayCount() {
    return curveDayCount;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the spotDays.
   * @return the value of the property, not null
   */
  public int getSpotDays() {
    return spotDays;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the fixedPaymentFrequency.
   * @return the value of the property, not null
   */
  public Frequency getFixedPaymentFrequency() {
    return fixedPaymentFrequency;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the badDayConvention.
   * @return the value of the property, not null
   */
  public BusinessDayConvention getBadDayConvention() {
    return badDayConvention;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the holidayCalendar.
   * @return the value of the property, not null
   */
  public HolidayCalendar getHolidayCalendar() {
    return holidayCalendar;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      IsdaYieldCurveConvention other = (IsdaYieldCurveConvention) obj;
      return JodaBeanUtils.equal(getCurrency(), other.getCurrency()) &&
          JodaBeanUtils.equal(getMmDayCount(), other.getMmDayCount()) &&
          JodaBeanUtils.equal(getFixedDayCount(), other.getFixedDayCount()) &&
          JodaBeanUtils.equal(getCurveDayCount(), other.getCurveDayCount()) &&
          (getSpotDays() == other.getSpotDays()) &&
          JodaBeanUtils.equal(getFixedPaymentFrequency(), other.getFixedPaymentFrequency()) &&
          JodaBeanUtils.equal(getBadDayConvention(), other.getBadDayConvention()) &&
          JodaBeanUtils.equal(getHolidayCalendar(), other.getHolidayCalendar());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getCurrency());
    hash = hash * 31 + JodaBeanUtils.hashCode(getMmDayCount());
    hash = hash * 31 + JodaBeanUtils.hashCode(getFixedDayCount());
    hash = hash * 31 + JodaBeanUtils.hashCode(getCurveDayCount());
    hash = hash * 31 + JodaBeanUtils.hashCode(getSpotDays());
    hash = hash * 31 + JodaBeanUtils.hashCode(getFixedPaymentFrequency());
    hash = hash * 31 + JodaBeanUtils.hashCode(getBadDayConvention());
    hash = hash * 31 + JodaBeanUtils.hashCode(getHolidayCalendar());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(288);
    buf.append("IsdaYieldCurveConvention{");
    buf.append("currency").append('=').append(getCurrency()).append(',').append(' ');
    buf.append("mmDayCount").append('=').append(getMmDayCount()).append(',').append(' ');
    buf.append("fixedDayCount").append('=').append(getFixedDayCount()).append(',').append(' ');
    buf.append("curveDayCount").append('=').append(getCurveDayCount()).append(',').append(' ');
    buf.append("spotDays").append('=').append(getSpotDays()).append(',').append(' ');
    buf.append("fixedPaymentFrequency").append('=').append(getFixedPaymentFrequency()).append(',').append(' ');
    buf.append("badDayConvention").append('=').append(getBadDayConvention()).append(',').append(' ');
    buf.append("holidayCalendar").append('=').append(JodaBeanUtils.toString(getHolidayCalendar()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code IsdaYieldCurveConvention}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code currency} property.
     */
    private final MetaProperty<Currency> currency = DirectMetaProperty.ofImmutable(
        this, "currency", IsdaYieldCurveConvention.class, Currency.class);
    /**
     * The meta-property for the {@code mmDayCount} property.
     */
    private final MetaProperty<DayCount> mmDayCount = DirectMetaProperty.ofImmutable(
        this, "mmDayCount", IsdaYieldCurveConvention.class, DayCount.class);
    /**
     * The meta-property for the {@code fixedDayCount} property.
     */
    private final MetaProperty<DayCount> fixedDayCount = DirectMetaProperty.ofImmutable(
        this, "fixedDayCount", IsdaYieldCurveConvention.class, DayCount.class);
    /**
     * The meta-property for the {@code curveDayCount} property.
     */
    private final MetaProperty<DayCount> curveDayCount = DirectMetaProperty.ofImmutable(
        this, "curveDayCount", IsdaYieldCurveConvention.class, DayCount.class);
    /**
     * The meta-property for the {@code spotDays} property.
     */
    private final MetaProperty<Integer> spotDays = DirectMetaProperty.ofImmutable(
        this, "spotDays", IsdaYieldCurveConvention.class, Integer.TYPE);
    /**
     * The meta-property for the {@code fixedPaymentFrequency} property.
     */
    private final MetaProperty<Frequency> fixedPaymentFrequency = DirectMetaProperty.ofImmutable(
        this, "fixedPaymentFrequency", IsdaYieldCurveConvention.class, Frequency.class);
    /**
     * The meta-property for the {@code badDayConvention} property.
     */
    private final MetaProperty<BusinessDayConvention> badDayConvention = DirectMetaProperty.ofImmutable(
        this, "badDayConvention", IsdaYieldCurveConvention.class, BusinessDayConvention.class);
    /**
     * The meta-property for the {@code holidayCalendar} property.
     */
    private final MetaProperty<HolidayCalendar> holidayCalendar = DirectMetaProperty.ofImmutable(
        this, "holidayCalendar", IsdaYieldCurveConvention.class, HolidayCalendar.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "currency",
        "mmDayCount",
        "fixedDayCount",
        "curveDayCount",
        "spotDays",
        "fixedPaymentFrequency",
        "badDayConvention",
        "holidayCalendar");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 575402001:  // currency
          return currency;
        case -1714188141:  // mmDayCount
          return mmDayCount;
        case -1134209433:  // fixedDayCount
          return fixedDayCount;
        case -1661418270:  // curveDayCount
          return curveDayCount;
        case -1831990151:  // spotDays
          return spotDays;
        case 2136481162:  // fixedPaymentFrequency
          return fixedPaymentFrequency;
        case 909511720:  // badDayConvention
          return badDayConvention;
        case -30625866:  // holidayCalendar
          return holidayCalendar;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public IsdaYieldCurveConvention.Builder builder() {
      return new IsdaYieldCurveConvention.Builder();
    }

    @Override
    public Class<? extends IsdaYieldCurveConvention> beanType() {
      return IsdaYieldCurveConvention.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code currency} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Currency> currency() {
      return currency;
    }

    /**
     * The meta-property for the {@code mmDayCount} property.
     * @return the meta-property, not null
     */
    public MetaProperty<DayCount> mmDayCount() {
      return mmDayCount;
    }

    /**
     * The meta-property for the {@code fixedDayCount} property.
     * @return the meta-property, not null
     */
    public MetaProperty<DayCount> fixedDayCount() {
      return fixedDayCount;
    }

    /**
     * The meta-property for the {@code curveDayCount} property.
     * @return the meta-property, not null
     */
    public MetaProperty<DayCount> curveDayCount() {
      return curveDayCount;
    }

    /**
     * The meta-property for the {@code spotDays} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Integer> spotDays() {
      return spotDays;
    }

    /**
     * The meta-property for the {@code fixedPaymentFrequency} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Frequency> fixedPaymentFrequency() {
      return fixedPaymentFrequency;
    }

    /**
     * The meta-property for the {@code badDayConvention} property.
     * @return the meta-property, not null
     */
    public MetaProperty<BusinessDayConvention> badDayConvention() {
      return badDayConvention;
    }

    /**
     * The meta-property for the {@code holidayCalendar} property.
     * @return the meta-property, not null
     */
    public MetaProperty<HolidayCalendar> holidayCalendar() {
      return holidayCalendar;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 575402001:  // currency
          return ((IsdaYieldCurveConvention) bean).getCurrency();
        case -1714188141:  // mmDayCount
          return ((IsdaYieldCurveConvention) bean).getMmDayCount();
        case -1134209433:  // fixedDayCount
          return ((IsdaYieldCurveConvention) bean).getFixedDayCount();
        case -1661418270:  // curveDayCount
          return ((IsdaYieldCurveConvention) bean).getCurveDayCount();
        case -1831990151:  // spotDays
          return ((IsdaYieldCurveConvention) bean).getSpotDays();
        case 2136481162:  // fixedPaymentFrequency
          return ((IsdaYieldCurveConvention) bean).getFixedPaymentFrequency();
        case 909511720:  // badDayConvention
          return ((IsdaYieldCurveConvention) bean).getBadDayConvention();
        case -30625866:  // holidayCalendar
          return ((IsdaYieldCurveConvention) bean).getHolidayCalendar();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code IsdaYieldCurveConvention}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<IsdaYieldCurveConvention> {

    private Currency currency;
    private DayCount mmDayCount;
    private DayCount fixedDayCount;
    private DayCount curveDayCount;
    private int spotDays;
    private Frequency fixedPaymentFrequency;
    private BusinessDayConvention badDayConvention;
    private HolidayCalendar holidayCalendar;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(IsdaYieldCurveConvention beanToCopy) {
      this.currency = beanToCopy.getCurrency();
      this.mmDayCount = beanToCopy.getMmDayCount();
      this.fixedDayCount = beanToCopy.getFixedDayCount();
      this.curveDayCount = beanToCopy.getCurveDayCount();
      this.spotDays = beanToCopy.getSpotDays();
      this.fixedPaymentFrequency = beanToCopy.getFixedPaymentFrequency();
      this.badDayConvention = beanToCopy.getBadDayConvention();
      this.holidayCalendar = beanToCopy.getHolidayCalendar();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 575402001:  // currency
          return currency;
        case -1714188141:  // mmDayCount
          return mmDayCount;
        case -1134209433:  // fixedDayCount
          return fixedDayCount;
        case -1661418270:  // curveDayCount
          return curveDayCount;
        case -1831990151:  // spotDays
          return spotDays;
        case 2136481162:  // fixedPaymentFrequency
          return fixedPaymentFrequency;
        case 909511720:  // badDayConvention
          return badDayConvention;
        case -30625866:  // holidayCalendar
          return holidayCalendar;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 575402001:  // currency
          this.currency = (Currency) newValue;
          break;
        case -1714188141:  // mmDayCount
          this.mmDayCount = (DayCount) newValue;
          break;
        case -1134209433:  // fixedDayCount
          this.fixedDayCount = (DayCount) newValue;
          break;
        case -1661418270:  // curveDayCount
          this.curveDayCount = (DayCount) newValue;
          break;
        case -1831990151:  // spotDays
          this.spotDays = (Integer) newValue;
          break;
        case 2136481162:  // fixedPaymentFrequency
          this.fixedPaymentFrequency = (Frequency) newValue;
          break;
        case 909511720:  // badDayConvention
          this.badDayConvention = (BusinessDayConvention) newValue;
          break;
        case -30625866:  // holidayCalendar
          this.holidayCalendar = (HolidayCalendar) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public IsdaYieldCurveConvention build() {
      return new IsdaYieldCurveConvention(
          currency,
          mmDayCount,
          fixedDayCount,
          curveDayCount,
          spotDays,
          fixedPaymentFrequency,
          badDayConvention,
          holidayCalendar);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code currency} property in the builder.
     * @param currency  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder currency(Currency currency) {
      JodaBeanUtils.notNull(currency, "currency");
      this.currency = currency;
      return this;
    }

    /**
     * Sets the {@code mmDayCount} property in the builder.
     * @param mmDayCount  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder mmDayCount(DayCount mmDayCount) {
      JodaBeanUtils.notNull(mmDayCount, "mmDayCount");
      this.mmDayCount = mmDayCount;
      return this;
    }

    /**
     * Sets the {@code fixedDayCount} property in the builder.
     * @param fixedDayCount  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder fixedDayCount(DayCount fixedDayCount) {
      JodaBeanUtils.notNull(fixedDayCount, "fixedDayCount");
      this.fixedDayCount = fixedDayCount;
      return this;
    }

    /**
     * Sets the {@code curveDayCount} property in the builder.
     * @param curveDayCount  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder curveDayCount(DayCount curveDayCount) {
      JodaBeanUtils.notNull(curveDayCount, "curveDayCount");
      this.curveDayCount = curveDayCount;
      return this;
    }

    /**
     * Sets the {@code spotDays} property in the builder.
     * @param spotDays  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder spotDays(int spotDays) {
      JodaBeanUtils.notNull(spotDays, "spotDays");
      this.spotDays = spotDays;
      return this;
    }

    /**
     * Sets the {@code fixedPaymentFrequency} property in the builder.
     * @param fixedPaymentFrequency  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder fixedPaymentFrequency(Frequency fixedPaymentFrequency) {
      JodaBeanUtils.notNull(fixedPaymentFrequency, "fixedPaymentFrequency");
      this.fixedPaymentFrequency = fixedPaymentFrequency;
      return this;
    }

    /**
     * Sets the {@code badDayConvention} property in the builder.
     * @param badDayConvention  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder badDayConvention(BusinessDayConvention badDayConvention) {
      JodaBeanUtils.notNull(badDayConvention, "badDayConvention");
      this.badDayConvention = badDayConvention;
      return this;
    }

    /**
     * Sets the {@code holidayCalendar} property in the builder.
     * @param holidayCalendar  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder holidayCalendar(HolidayCalendar holidayCalendar) {
      JodaBeanUtils.notNull(holidayCalendar, "holidayCalendar");
      this.holidayCalendar = holidayCalendar;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(288);
      buf.append("IsdaYieldCurveConvention.Builder{");
      buf.append("currency").append('=').append(JodaBeanUtils.toString(currency)).append(',').append(' ');
      buf.append("mmDayCount").append('=').append(JodaBeanUtils.toString(mmDayCount)).append(',').append(' ');
      buf.append("fixedDayCount").append('=').append(JodaBeanUtils.toString(fixedDayCount)).append(',').append(' ');
      buf.append("curveDayCount").append('=').append(JodaBeanUtils.toString(curveDayCount)).append(',').append(' ');
      buf.append("spotDays").append('=').append(JodaBeanUtils.toString(spotDays)).append(',').append(' ');
      buf.append("fixedPaymentFrequency").append('=').append(JodaBeanUtils.toString(fixedPaymentFrequency)).append(',').append(' ');
      buf.append("badDayConvention").append('=').append(JodaBeanUtils.toString(badDayConvention)).append(',').append(' ');
      buf.append("holidayCalendar").append('=').append(JodaBeanUtils.toString(holidayCalendar));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
