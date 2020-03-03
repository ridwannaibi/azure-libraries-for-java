/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.azure.management;

import com.azure.core.http.rest.PagedIterable;
import com.azure.management.compute.KnownWindowsVirtualMachineImage;
import com.azure.management.compute.VirtualMachine;
import com.azure.management.compute.VirtualMachineSize;
import com.azure.management.compute.VirtualMachines;
import com.azure.management.resources.core.TestUtilities;
import com.azure.management.resources.fluentcore.arm.Region;
import org.junit.jupiter.api.Assertions;

public class TestVirtualMachineSizes extends TestTemplate<VirtualMachine, VirtualMachines> {
    @Override
    public VirtualMachine createResource(VirtualMachines virtualMachines) throws Exception {
        PagedIterable<VirtualMachineSize> availableSizes = virtualMachines.sizes().listByRegion(Region.US_EAST);
        Assertions.assertTrue(TestUtilities.getSize(availableSizes) > 0);
        VirtualMachineSize availableSize = availableSizes.iterator().next();
        System.out.println("VM Sizes: " + availableSizes);
        final String vmName = virtualMachines.manager().getSdkContext().randomResourceName("vm", 10);
        VirtualMachine vm = virtualMachines.define(vmName)
                .withRegion(Region.US_EAST)
                .withNewResourceGroup()
                .withNewPrimaryNetwork("10.0.0.0/28")
                .withPrimaryPrivateIPAddressDynamic()
                .withoutPrimaryPublicIPAddress()
                .withPopularWindowsImage(KnownWindowsVirtualMachineImage.WINDOWS_SERVER_2012_R2_DATACENTER)
                .withAdminUsername("testuser")
                .withAdminPassword("12NewPA$$w0rd!")
                .withSize(availableSize.name()) // Use the first size
                .create();

        Assertions.assertTrue(vm.size().toString().equalsIgnoreCase(availableSize.name()));
        return vm;
    }

    @Override
    public VirtualMachine updateResource(VirtualMachine virtualMachine) throws Exception {
        PagedIterable<VirtualMachineSize> resizableSizes = virtualMachine.availableSizes();
        Assertions.assertTrue(TestUtilities.getSize(resizableSizes) > 0);
        VirtualMachineSize newSize = null;
        for (VirtualMachineSize resizableSize : resizableSizes) {
            if (!resizableSize.name().equalsIgnoreCase(virtualMachine.size().toString())) {
                newSize = resizableSize;
                break;
            }
        }
        Assertions.assertNotNull(newSize);
        virtualMachine = virtualMachine.update()
                .withSize(newSize.name())
                .apply();

        Assertions.assertTrue(virtualMachine.size().toString().equalsIgnoreCase(newSize.name()));
        return virtualMachine;
    }

    @Override
    public void print(VirtualMachine virtualMachine) {

    }
}
