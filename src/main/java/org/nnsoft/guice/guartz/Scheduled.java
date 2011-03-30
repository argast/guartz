/*
 *    Copyright 2009-2011 The 99 Software Foundation
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.nnsoft.guice.guartz;

import static org.quartz.utils.Key.DEFAULT_GROUP;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Scheduled {

    public static final String DEFAULT = "##default";

    // Job

    /**
     * The name must be unique within the group.
     *
     * @return
     */
    String jobName();

    /**
     * 
     *
     * @return
     */
    String jobGroup() default DEFAULT_GROUP;

    /**
     * Instructs the Scheduler whether or not the Job
     * should be re-executed if a 'recovery' or 'fail-over' situation is
     * encountered.
     *
     * @return
     */
    boolean requestRecovery() default false;

    /**
     * Whether or not the Job should remain stored after it is
     * orphaned
     *
     * @return
     */
    boolean storeDurably() default false;

    // Trigger

    /**
     * The name must be unique within the group.
     */
    String triggerName() default DEFAULT;

    String triggerGroup() default DEFAULT_GROUP;

    String cronExpression();

    /**
     * Returns the time zone for which the {@code cronExpression}
     * of this {@code CronTrigger} will be resolved.
     * 
     * @return
     */
    String timeZoneId() default DEFAULT;

    /**
     * Set the Trigger's priority.  When more than one Trigger have the same
     * fire time, the scheduler will fire the one with the highest priority
     * first.
     *
     * @return
     */
    int priority() default 0;

}
