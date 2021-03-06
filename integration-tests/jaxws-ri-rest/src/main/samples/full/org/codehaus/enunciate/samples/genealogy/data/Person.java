/*
 * Copyright 2006-2008 Web Cohesion
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codehaus.enunciate.samples.genealogy.data;

import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.enunciate.samples.genealogy.services.impl.EventDescriptionAdapter;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import java.util.Collection;
import java.util.Map;

/**
 * A person.  The central data in genealogical information.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
public class Person<E extends Event> {

  private String id;
  private Gender gender;
  private Collection<? extends Name> names;
  private Collection<E> events;
  private Collection<? extends Fact> facts;
  private Collection<? extends Relationship> relationships;
  private Map<EventType, String> eventDescriptions;

  private DataHandler picture;
  private byte[] recording;
  private Map<QName, String> otherAttributes;
  private SelfReferencingThing selfReferencingThing;

  /**
   * The person id.
   *
   * @return The person id.
   */
  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  /**
   * The person id.
   *
   * @param id The person id.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The gender of a person.
   *
   * @return The gender of a person.
   */
  public Gender getGender() {
    return gender;
  }

  /**
   * The gender of a person.
   *
   * @param gender The gender of a person.
   */
  public void setGender(Gender gender) {
    this.gender = gender;
  }

  /**
   * The names of the person.
   *
   * @return The names of the person.
   */
  public Collection<? extends Name> getNames() {
    return names;
  }

  /**
   * The names of the person.
   *
   * @param names The names of the person.
   */
  public void setNames(Collection<? extends Name> names) {
    this.names = names;
  }

  /**
   * The events associated with a person.
   *
   * @return The events associated with a person.
   */
  public Collection<E> getEvents() {
    return events;
  }

  /**
   * The events associated with a person.
   *
   * @param events The events associated with a person.
   */
  public void setEvents(Collection<E> events) {
    this.events = events;
  }

  /**
   * The facts about a person.
   *
   * @return The facts about a person.
   */
  public Collection<? extends Fact> getFacts() {
    return facts;
  }

  /**
   * The facts about a person.
   *
   * @param facts The facts about a person.
   */
  public void setFacts(Collection<? extends Fact> facts) {
    this.facts = facts;
  }

  /**
   * The relationships of a person.
   *
   * @return The relationships of a person.
   */
  public Collection<? extends Relationship> getRelationships() {
    return relationships;
  }

  /**
   * The relationships of a person.
   *
   * @param relationships The relationships of a person.
   */
  public void setRelationships(Collection<? extends Relationship> relationships) {
    this.relationships = relationships;
  }

  /**
   * A picture of a person.
   *
   * @return A picture of a person.
   */
  public DataHandler getPicture() {
    return picture;
  }

  /**
   * A picture of a person.
   *
   * @param picture A picture of a person.
   */
  public void setPicture(DataHandler picture) {
    this.picture = picture;
  }

  @XmlJavaTypeAdapter ( EventDescriptionAdapter.class )
  public Map<EventType, String> getEventDescriptions() {
    return eventDescriptions;
  }

  public void setEventDescriptions(Map<EventType, String> eventDescriptions) {
    this.eventDescriptions = eventDescriptions;
  }

  @XmlJavaTypeAdapter( HexBinaryAdapter.class )
  public byte[] getRecording() {
    return recording;
  }

  public void setRecording(byte[] recording) {
    this.recording = recording;
  }

  @XmlAnyAttribute
  @XmlQNameEnumRef(FavoriteFood.class)
  public Map<QName, String> getOtherAttributes() {
    return otherAttributes;
  }

  public void setOtherAttributes(Map<QName, String> otherAttributes) {
    this.otherAttributes = otherAttributes;
  }

  public SelfReferencingThing getSelfReferencingThing() {
    return selfReferencingThing;
  }

  public void setSelfReferencingThing(SelfReferencingThing selfReferencingThing) {
    this.selfReferencingThing = selfReferencingThing;
  }
}
