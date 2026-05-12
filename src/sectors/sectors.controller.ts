import {
  Controller,
  Get,
  Param,
  Query,
} from '@nestjs/common';

import { SectorsService } from './sectors.service';

import { FilterSectorDto } from './dto/filter-sector.dto';

@Controller('sectors')
export class SectorsController {

  constructor(
    private readonly sectorsService: SectorsService,
  ) {}

  @Get()
  findAll(
    @Query() filters: FilterSectorDto,
  ) {

    return this.sectorsService.findAll(filters);
  }

  @Get(':id')
  findOne(
    @Param('id') id: string,
  ) {

    return this.sectorsService.findOne(Number(id));
  }
}